package by.it.verbitsky.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Offer shopOffer;

    //можно попробовать сделать volatile
    private static volatile ShopManager shopManager;
    private static List<Buyer> threads = new ArrayList<>();


    public static void main(String[] args) {
        generateOffers();
        createShopmanager();
        openShop();
        closeShop();
    }

    private static void createShopmanager() {
        System.out.println("create shop manager");
        shopManager = new ShopManager();
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
        System.out.println("Shop opened\n\n");
        for (int i = 0; i < 120; i++) {
            //каждую секунду запускаем несколько покупателей (зависит от времени и кол-ва которые уже находятся в магазине
            int countEntered = Helper.getCountFactor(i, getShopManager().getBuyers().size());
            boolean oldMan = false;//флаг для определения пенсионера
            for (int j = 0; j < countEntered; j++) {
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
                getShopManager().addBuyer(buyer);
                threads.add(buyer);
                //запускаем поток
                buyer.start();
            }
            /*
                Т.к. цикл не гарантирует итерацию в 1 секунду - принудительно слипаем класный поток
                это гарантия того, что мы принимаем покупателей 2 минуты (цикл 120 раз, 1000мс = 1 секунда - всего 2 минуты)

                //в зависимости от временного интервала и кол-ва покупателей
                  ускоряем либо замедляем процессы у покупателей, путем изменения speedfactor'a
            */

            Helper.sleep(1000);
            System.out.println("---------------------" +
                    "Прошло секунд " + i % 60);

            System.out.println("---------------------" +
                    "Всего покупателей в магазине: " + getShopManager().getBuyers().size());
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
}
