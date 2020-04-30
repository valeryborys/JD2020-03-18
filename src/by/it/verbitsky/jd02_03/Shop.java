package by.it.verbitsky.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class Shop extends Thread {
//class Shop implements Runnable {

    private Offer shopOffer;
    private AtomicReference<NShopManager> shopManager;
    private AtomicReference<QueueManager> queueManager;
    private int plan = 100;
    private int cashierLimit = 5;
    private int queueCapacity = 30;
    private ExecutorService shopManagerPool;

    public Shop() {
        super("shop");
    }

    public Shop(int plan, int limit, int queueCapacity) {
        this.plan = plan;
        this.cashierLimit = limit;
        this.queueCapacity = queueCapacity;
    }

    //private List<Buyer> threads = new ArrayList<>();


    @Override
    public void run() {
        System.out.println("SERVICE SPEED FACTOR = " + Helper.getServiceSpeedFactor());
        generateOffers();
        createQueueManager();
        createShopManager();
        //сервис слип замораживает поток на точное время, без учета коэффициента ускорения
        Helper.serviceSleep(2000);
        openShop();
        closeShop();
    }

    private void createQueueManager() {
        System.out.println("создаем манагера очереди");
        queueManager = new AtomicReference<>(new QueueManager(this));
        System.out.println("размер очереди: " + queueManager.get().getQueueSize());
    }

    private void createShopManager() {
        // ShopPrinter.printMessage("Create shop manager");
        shopManager = new AtomicReference<>(new NShopManager(this));
        shopManagerPool = Executors.newFixedThreadPool(1);
        shopManagerPool.execute(shopManager.get());
        //манагер управляет главным потоком (магазином)
        //т.е. пока живет поток манагера - живет поток магазина


    }

    private void generateOffers() {
        //ShopPrinter.printMessage("create offers");
        shopOffer = new Offer();
    }

    private static void closeShop() {
        ShopPrinter.printMessage("\n\nshop closed");
    }

    private void openShop() {
        int num = 0;
        int i = 0;
        // ShopPrinter.printMessage("\n\nShop opened\n");

        while (!shopManager.get().isShopOpen()) {
            i++;
            //каждую секунду запускаем несколько покупателей (зависит от времени и кол-ва которые уже находятся в магазине
            int countEntered = Helper.getCountFactor(i, shopManager.get().getCurrentBuyersCount());
            boolean oldMan = false;//флаг для определения пенсионера
            for (int j = 0; !shopManager.get().isShopOpen() & j < countEntered; j++) {
                if (shopManager.get().getCurrentBuyersCount() == 40) {
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
                Buyer buyer = new Buyer(this, ++num, oldMan);
                oldMan = false; //обнуляем флаг
                //threads.add(buyer);
                //запускаем поток
                buyer.start();
            }

            Helper.sleep(1000);
            //ShopPrinter.printMessage("----------------------Seconds passed " + i % 60);
            // ShopPrinter.printMessage("----------------------Buyers in: " + shopManager.getCurrentBuyersCount());
            System.out.println("----------------------Seconds passed " + i % 60);
            System.out.println("----------------------Buyers in: " + shopManager.get().getCurrentBuyersCount());
        }

        shopManagerPool.shutdown();
        //ждем пока не завершится поток шоп манагера
        try {
            while (!shopManagerPool.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //вернуть предложения товаров с ценами
    protected Offer getShopOffer() {
        return shopOffer;
    }

    //вернуть шоп манагера
    public NShopManager getShopManager() {
        return shopManager.get();
    }

    //вернуть манагера очереди
    public QueueManager getQueueManager() {
        return queueManager.get();
    }

    public void setBuyersPlan(int plan) {
        this.plan = plan;
    }

    public int getBuyersPlan() {
        return this.plan;
    }

    public int getCashierLimit() {
        return this.cashierLimit;
    }

    public void setCashierLimit(int limit) {
        this.cashierLimit = limit;
    }

    public void setQueueCapacity(int capacity) {
        this.queueCapacity = capacity;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }
}
