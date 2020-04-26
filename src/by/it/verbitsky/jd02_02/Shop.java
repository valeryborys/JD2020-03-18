package by.it.verbitsky.jd02_02;


import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Offer shopOffer;

    private static volatile ShopManager shopManager;
    private static List<Buyer> threads = new ArrayList<>();

    public static void main(String[] args) {
        generateOffers();
        createShopmanager();
        createCashiers();
        Helper.sleep(1000);
        openShop();
        closeShop();
    }

    private static void createCashiers() {
        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i);
            System.out.println("создали кассира " + i);
            synchronized (ShopManager.getCashierMonitor()) {
                cashier.start();
            }
            shopManager.getCashiers().add(cashier);
        }
    }

    private static void createShopmanager() {
        System.out.println("create shop manager");
        shopManager = new ShopManager();
        shopManager.start();
        //манагер управляет главным потоком (магазином)
        //т.е. пока живет поток манагера - магазин открыт
        System.out.println("end create shop manager");
    }

    private static void generateOffers() {
        System.out.println("create offers");
        shopOffer = new Offer();
    }

    private static void closeShop() {
        System.out.println("\n\nshop closed");
    }

    private static void openShop() {
        int num = 0;
        int i = 0;
        System.out.println("Shop opened\n\n");
        //разбиать на отдельные методы
        while (!ShopManager.isShopOpen()) {
            i++;
            //каждую секунду запускаем несколько покупателей (зависит от времени и кол-ва которые уже находятся в магазине
            int countEntered = Helper.getCountFactor(i, shopManager.getCurrentBuyersCount());
            boolean oldMan = false;//флаг для определения пенсионера
            for (int j = 0; !ShopManager.isShopOpen() && j < countEntered; j++) {
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
            System.out.println("---------------------------------------------------------Прошло секунд " + i % 60);
            System.out.println("кол-во людей в очереди: " + ShopQueue.getQueueCount());
            System.out.println("кол-во свободных касс: " + shopManager.getAvailableCashes());
        }
        try {
            System.out.println("закрепили манагера в основном потоке");
            shopManager.printFreeCashiers();
            shopManager.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

/*
            System.out.println("---------------------" +
                    "Всего покупателей в магазине: " + getShopManager().getBuyers().size());
            //Для построения диаграммы чтобы проверить график
            writeLog(getShopManager().getBuyers().size());
        }

        //теперь нужна задержка для того, чтобы закрепить потоки покупателей перед основным поток main
        //слипаем на пару мс основной поток и после этого закрепляем потоки

        Helper.sleep(3000);
        for (Buyer buyer : threads) {
            try {
                //закрепляем поток каждого покупателя перед основным поток выполнения
                //чтобы главный поток магазина не закрылся ранньше чем потоки покупателей
                buyer.join();
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
        }
/*
        for (Buyer buyer : getShopManager().getBuyers()) {
            try {
                //закрепляем поток каждого покупателя перед основным поток выполнения
                //чтобы главный поток магазина не закрылся ранньше чем потоки покупателей
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        */
    }

    //вернуть предложения товаров с ценами
    public static Offer getShopOffer() {
        return shopOffer;
    }

    //вернуть шоп манагера
    public static ShopManager getShopManager() {
        return shopManager;
    }
/*  тестовый лог
    private static void writeLog(int count) {
        try {
            String fName = "I:\\__Javastudy\\_training\\JD2020-03-18\\src\\by\\it\\verbitsky\\jd02_02\\logshop.txt";
            File f = new File(fName);
            if (!f.exists()) {
                f.createNewFile();
            }
            String text = "" + count;
            Files.write(Paths.get(fName), text.concat("\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }*/
}
