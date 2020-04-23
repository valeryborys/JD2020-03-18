package by.it.verbitsky.jd02_01;

import java.util.Locale;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private Backet backet;
    private boolean pensioner;
    private double speedFactor;

    /*
        public Buyer(int number) {
            //передали имя в суперкласс
            //конструктор присвоит потоку переданное имя
            super("Buyer № " + number + " ");
        }
    */
    public Buyer(int number, boolean oldMan) {
        //передали имя в суперкласс
        //конструктор присвоит потоку переданное имя
        super("Buyer № " + number + " ");
        this.pensioner = oldMan;
        if (pensioner) {
            speedFactor = 1.5;
        } else {
            speedFactor = 1;
        }
    }

    public Backet getBacket() {
        return backet;
    }

    @Override
    public void run() {
        enterToMarket();//мгновенно
        takeBacket();// мгновенно
        chooseGoods();//0,5 - 2 секунды / *1.5 для пенсионеров
        goOut(); //мгновенно
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " начал выбирать товары");
        int chooseTimeOut = Helper.getRandomTimeout(500, 2000, speedFactor);
        Helper.sleep(chooseTimeOut);
        int goodsCount = Helper.getRandom(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            Helper.sleep(Helper.getRandomTimeout(500, 2000, speedFactor));
            putGoodsToBacket();
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + "закончил выбор товаров");


    }

    @Override
    public void goOut() {
        System.out.println(this + " покинул магазин");
        Shop.getShopManager().removeBuyer(this);
    }


    // Работа с корзиной покупателя
    @Override
    public void takeBacket() {
        System.out.println(this + " взял корзину");
        if (backet == null) {
            backet = new Backet();
        }
    }

    @Override
    public void putGoodsToBacket() {
        Good good = Shop.getShopOffer().getRandomGood();
        backet.getGoodList().add(good);
        System.out.printf(Locale.ENGLISH,
                "%s положил товар %s по цене %3.2f в корзину\n",
                this, good.getName(), good.getPrice());
    }

    @Override
    public String toString() {
        String status = "";
        if (pensioner) {
            status = " (пенсионер)";
        }
        return getName().concat(status);
    }
}
