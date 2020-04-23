package by.it.verbitsky.jd02_01;

class Shop {
    private static Offer shopOffer;

    //можно попробовать сделать volatile
    private static volatile ShopManager shopManager;


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
            //каждую секунду запускаем от 0 до 2-х покупателей
            int countEntered = Helper.getCountFactor(i, shopManager.getBuyers().size());
            int pensionerFactor = Helper.getRandom(1, 4);
            boolean oldMan = false;
            for (int j = 0; j < countEntered; j++) {
                //создали поток (но он еще не запущен)
                if (pensionerFactor == 4) {
                    oldMan = true;
                }
                Buyer buyer = new Buyer(++num, oldMan);
                shopManager.addBuyer(buyer);
                //запускаем поток
                buyer.start();
            }
            /*
                Т.к. цикл не гарантирует итерацию в 1 секунду - принудительно слипаем класный поток
                это гарантия того, что мы принимаем покупателей 2 минуты (цикл 120 раз, 1000мс = 1 секунда - всего 2 минуты)

                //в зависимости от временного интервала и кол-ва покупателей
                  ускоряем либо замедляем процессы у покупателей, путем изменения
                  speedfactor'a - пока сделал через кол-во покупателей за секунду, а не через увеличение задержек
             */


            Helper.sleep(1000);
            System.out.println("Прошло секунд " + i % 60);

            System.out.println("---------------------" +
                    "Всего покупателей в магазине: " + shopManager.getBuyers().size());
        }

        //теперь нужна задержка для того, чтобы закрепить потоки покупателей перед основным поток main
        //слипаем на пару мс основной поток и после этого закрепляем потоки

        Helper.sleep(5000);


        for (Buyer buyer : shopManager.getBuyers()) {
            try {
                //закрепляем поток каждого покупателя перед основным поток выполнения
                //чтобы главный поток магазина не закрылся ранньше чем потоки покупателей
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
