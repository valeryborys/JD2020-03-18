package by.it.verbitsky.jd02_02;


import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Offer shopOffer;

    private static volatile ShopManager shopManager;
    private static List<Buyer> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("SERVICE SPEED FACTOR = " + Helper.getServiceSpeedFactor());
        generateOffers();
        createShopmanager();
        createCashiers();
        //сервис слип замораживает поток на точное время, без учета коэффициента ускорения
        Helper.serviceSleep(2000);
        openShop();
        closeShop();
    }

    private static void createCashiers() {
        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i);
            ShopPrinter.printMessage("Create cashier " + i);
            synchronized (ShopManager.getCashierMonitor()) {
                cashier.start();
            }
            shopManager.getCashiers().add(cashier);
        }
    }

    private static void createShopmanager() {
        ShopPrinter.printMessage("Create shop manager");
        shopManager = new ShopManager();
        shopManager.start();
        //манагер управляет главным потоком (магазином)
        //т.е. пока живет поток манагера - живет поток магазина
    }

    private static void generateOffers() {
        ShopPrinter.printMessage("create offers");
        shopOffer = new Offer();
    }

    private static void closeShop() {
        ShopPrinter.printMessage("\n\nshop closed");
    }

    private static void openShop() {
        int num = 0;
        int i = 0;
        ShopPrinter.printMessage("\n\nShop opened\n");
        while (!ShopManager.isShopOpen()) {
            i++;
            //каждую секунду запускаем несколько покупателей (зависит от времени и кол-ва которые уже находятся в магазине
            int countEntered = Helper.getCountFactor(i, shopManager.getCurrentBuyersCount());
            boolean oldMan = false;//флаг для определения пенсионера
            for (int j = 0; !ShopManager.isShopOpen() && j < countEntered; j++) {
                if (shopManager.getCurrentBuyersCount() == 40) {
                    //не более 40 человек после 30 сек
                    break;
                }
                if (num % 4 == 0) {
                    //если покупатель 4-й, то с вероятностью 50/50 он будет пенсионер, но если нет, то 5-й будет точно
                    int coin = Helper.getRandom(1, 2); //подкидываем монетку
                    if (coin == 1) {
                        oldMan = true; //покупатель будет пенсионер
                    }
                }
                //если 4-й покупатель не был пенсионером, то 5-й будет обязательно
                if (num % 5 == 0 && !oldMan) {
                    oldMan = true;
                }
                //создали поток (но он еще не запущен)
                Buyer buyer = new Buyer(++num, oldMan);
                oldMan = false; //обнуляем флаг
                threads.add(buyer);
                //запускаем поток
                buyer.start();
            }

            Helper.sleep(1000);
            ShopPrinter.printMessage("----------------------Seconds passed " + i % 60);
            ShopPrinter.printMessage("----------------------Buyers in: " + shopManager.getCurrentBuyersCount());
        }
        try {
            System.out.println("закрепили манагера в основном потоке");
            shopManager.printCashiersStatus();
            shopManager.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //вернуть предложения товаров с ценами
    public static Offer getShopOffer() {
        return shopOffer;
    }

    //вернуть шоп манагера
    public static ShopManager getShopManager() {
        return shopManager;
    }
}
