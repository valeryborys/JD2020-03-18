package by.it.lemesh.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    public static int buyersOnline;
    boolean pensioner;
    Map<String, Integer> goods = new HashMap<>();

    public Buyer(int number, String pensioner) {
        super("Buyer №:" + number + pensioner);
        Manager.buyerIn();
        if (pensioner.length() > 0) this.pensioner = true;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        toQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        int countOfGoods = Helper.getRandom(1, 4);
        for (int i = 0; i < countOfGoods; i++) {
            int j = Helper.getRandom(0, 9);
            String key = Helper.keysList.get(j);
            Integer value = Helper.map.get(key);
            System.out.println(this + " took " + key + " for " + value + " $");
            goods.put(key, value);
            int timeOut = Helper.getRandom(500, 2000);
            if (pensioner) timeOut = (int) (timeOut * 1.5);
            Helper.sleep(timeOut);
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " begin to choose goods");
        putGoodsToBasket();
        System.out.println(this + " has finished choosing goods");
    }

    @Override
    public void toQueue() {
        synchronized (this) {
            QueueBuyers.add(this);
            try {
                System.out.println(this + " added to queue");
                wait();
//                System.out.println(this + " left the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        Manager.BuyerOut();
        System.out.println(this + " exit market");
        if (Manager.planComplete()) Manager.closeTheMarket();
    }

    @Override
    public String toString() {
        return getName();
    }
}
