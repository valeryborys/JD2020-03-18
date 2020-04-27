package by.it.borys.jd02_02;

import by.it._examples_.jd01_08._06_Object.Man;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer = false;


    public Buyer(int number) {
        super("Buyer № " + number + " ");
        if (Helper.getRandom(0, 100)<25) pensioneer=true;
        Manager.buyersCount(true);
        Manager.buyerAddToShop();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
       putGoodsToBasket();
       goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        if (pensioneer) timeout *= 1.5;
        Helper.sleep(timeout);

    }

    @Override
    public void takeBacket() {
        System.out.println(this + "takes the basket");
//        int timeout = Helper.getRandom(500, 2000);
//        if (pensioneer) timeout *= 1.5;
//        Helper.sleep(timeout);
       }

    @Override
    public void putGoodsToBasket() {
        for (int i = 0; i < Helper.getRandom(1,4) ; i++) {
            System.out.println(this + "put the "+ randomGood()+ " to the basket");
            int timeout = Helper.getRandom(500, 2000);
            if (pensioneer) timeout *= 1.5;
            Helper.sleep(timeout);
        }
        System.out.println(this + "finished to choose goods");
    }

    private String randomGood(){
        int count=0;
        int choose = Helper.getRandom(0, Shop.goods.size());
        for (Map.Entry<String, Integer> good : Shop.goods.entrySet()) {
            if (count++ == choose) return good.getKey()+" for $ "+good.getValue();
        }return null;
    }

    @Override
    public void goToQueue() {
        synchronized (this){
        QueueBuyers.add(this);
            try {
                System.out.println(this + " added to queue" );
                wait();
                System.out.println(this + " leaved the queue" );
            } catch (InterruptedException e) {
                throw new RuntimeException("Ошибка",e);
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaved the shop");
        Manager.buyersCount(false);
        Manager.buyerLeaveTheShop();
    }
    @Override
    public String toString() {
        return getName();
    }
}
