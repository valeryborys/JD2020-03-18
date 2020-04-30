package by.it.verbitsky.jd02_03;

import java.util.Locale;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private boolean pensioner;
    private double speedFactor;

    public boolean isPensioner() {
        return pensioner;
    }

    public double getSpeedFactor() {
        return speedFactor;
    }

    public Buyer(int number, boolean isPensioner) {
        //передали имя в суперкласс
        //конструктор присвоит потоку переданное имя
        super("Buyer № " + number + " ");
        this.pensioner = isPensioner;
        if (pensioner) {
            speedFactor = 1.5;
        } else {
            speedFactor = 1;
        }
        Shop.getShopManager().addBuyer(this);

    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public void run() {
        enterToMarket();//мгновенно
        takeBasket();// мгновенно
        chooseGoods();//0,5 - 2 секунды / *1.5 для пенсионеров
        goToQueue();
        goOut(); //мгновенно
    }

    private void goToQueue() {
        synchronized (this) {
            ShopQueue.lineUp(this);
            try {
                ShopPrinter.printMessage(this + " add in queue");
                wait();
                ShopPrinter.printMessage(this + " покинул queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
        ShopPrinter.printMessage(this + " entered the shop");
    }

    @Override
    public void chooseGoods() {
        ShopPrinter.printMessage(this + " begin to choose goods");
        int chooseTimeOut = Helper.getRandomTimeout(500, 2000, speedFactor);
        Helper.sleep(chooseTimeOut);
        int goodsCount = Helper.getRandom(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            Helper.sleep(Helper.getRandomTimeout(500, 2000, speedFactor));
            putGoodsToBasket();
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShopPrinter.printMessage(this + "finish to choose goods");


    }

    @Override
    public void goOut() {
        ShopPrinter.printMessage(this + " leave the shop");
        Shop.getShopManager().removeBuyer(this);
    }


    // Работа с корзиной покупателя
    @Override
    public void takeBasket() {
        ShopPrinter.printMessage(this + " take a basket ");
        if (basket == null) {
            basket = new Basket();
        }
    }

    @Override
    public void putGoodsToBasket() {
        Good good = Shop.getShopOffer().getRandomGood();
        basket.getGoodList().add(good);
        String msg = String.format(Locale.ENGLISH,
                "%s put: %s with price: %3.2f in basket\n",
                this, good.getName(), good.getPrice());

        ShopPrinter.printMessage(msg);
    }

    @Override
    public String toString() {
        String status = "";
        if (pensioner) {
            status = " (pensioner)";
        }
        return getName().concat(status);
    }
}
