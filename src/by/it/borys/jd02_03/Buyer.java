package by.it.borys.jd02_03;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer = false;
    Basket basket= new Basket();
    private boolean waitState;
    private static Semaphore semaphore = new Semaphore(20);

    public void setWaitState(boolean waitState) {
        this.waitState = waitState;
    }

    public Buyer(int number) {
        super("Buyer № " + number + " ");
        if (Helper.getRandom(0, 100)<25) pensioneer=true;
       // Manager.buyersCount(true);
        Manager.buyerAddToShop();
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            semaphore.acquire();
            takeBacket();
            chooseGoods();
            putGoodsToBasket();
            goToQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
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
       }

    @Override
    public void putGoodsToBasket() {
            int random = Helper.getRandom(1, 4);
            for (int i = 0; i < random; i++) {
                HashMap<String, Integer> ranGood = Good.randomGood();
                for (Map.Entry<String, Integer> g : ranGood.entrySet()) {
                    basket.putToBasket(g.getKey(), g.getValue());
                    System.out.println(this + "put the " + g.getKey() + " for $" + g.getValue() + " to the basket");
                }
                int timeout = Helper.getRandom(500, 2000);
                if (pensioneer) timeout *= 1.5;
                Helper.sleep(timeout);
            }
            System.out.println(this + "finished to choose goods");
    }



    @Override
    public void goToQueue() {
            synchronized (this) {
                QueueBuyers.add(this);
                waitState = true;
                while (waitState) {
                    try {
                        System.out.println(this + " added to queue");
                        wait();
                        System.out.println(this + " leaved the queue");
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Ошибка", e);
                    }
                }
            }
    }

    @Override
    public void goOut() {
            System.out.println(this + "leaved the shop");
            // Manager.buyersCount(false);
            Manager.buyerLeaveTheShop();
    }
    @Override
    public String toString() {
        return getName();
    }
}
