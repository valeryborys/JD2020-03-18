package by.it.gutkovsky.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private int goodsQuantityInTheBasket = Helper.getRandom(1,4); // goods quantity in buyers shopping list
    private boolean pensioner;
    private static final double PENSIONER_FACTOR = 1.5;


    public Buyer(int number) {
        super("Buyer № " + number + " ");
        this.pensioner = false;
        Manager.customerComeIn();
    }

    public Buyer(int number, boolean pensioner) {
        super("Buyer № " + number + "(The Buyer is pensioner)" + " ");
        this.pensioner = pensioner;
        Manager.customerComeIn();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods(); // in this method buyer choose goods and put them into the basket
        goToQueue();
        goOut();
    }

    private void sleepMethod(int start, int stop, boolean pensioner) {
        int timeout;
        if (pensioner) {
            timeout = (int) (Helper.getRandom(start, stop) * PENSIONER_FACTOR);
        } else {
            timeout = Helper.getRandom(start, stop);
        }
        Helper.sleep(timeout);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to shop");

    }

    @Override
    public void takeBacket() {
        sleepMethod(500, 2000, pensioner);
        System.out.println(this + "take a basket");
    }

    @Override
    public Map<String, Double> chooseGoods() {
        System.out.println(this + "started to choose goods");
        Map<String, Double> shoppingList = new HashMap<>();
        for (int i = 0; i < goodsQuantityInTheBasket; i++) {
            sleepMethod(500, 2000, pensioner);

            //choose goods from goods shelf
            String goodsName = "Product" + Helper.getRandom(1, GoodsShelf.LIST_OF_GOODS_ON_SHELF.size()); // key for Map goodsOnShelf - chosenGoods
            double price = GoodsShelf.LIST_OF_GOODS_ON_SHELF.get(goodsName); // value for Map chosenGoods
            shoppingList.put(goodsName, price); // add chosen goods into private shopping list
            putGoodsToBacket(goodsName, price); // call the method which puts goods into the basket
        }
        System.out.println(this + "finished to choose goods");

        return shoppingList;
    }

    @Override
    public void putGoodsToBacket(String goodsName, double price) {
        sleepMethod(500, 2000, pensioner);
        System.out.println(this + "put " + goodsName + " to the basket, price for it is " + price + " BYN");
    }

    @Override
    public Map<String, Double> provideChosenGoodsToCashier(Map<String, Double> shoppingList) {
        return shoppingList;

    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            QueueBuyers.add(this);
            try {
                System.out.println(this + " added to queue");
                wait();
                System.out.println(this + " left the queue");
            } catch (InterruptedException e) {
                throw new RuntimeException("InterruptedException" + Thread.currentThread(), e);
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "left the shop");
        Manager.customerComeOut();
    }

    @Override
    public String toString() {
        return getName();
    }


}
