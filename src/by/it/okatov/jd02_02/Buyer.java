package by.it.okatov.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseCart {
    Cart cart;
    private static boolean elderMark;
    private static final float ELDER_COEF = 1.5f;
    static volatile int globalCount = 0;

    public static boolean isElderMark() {
        return elderMark;
    }

    public static void setElderMark(boolean elderMark) {
        Buyer.elderMark = elderMark;
    }

    private final Map<String, Integer> goods = new HashMap<>();

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map.Entry<String, Integer> entry) {
        this.goods.put(entry.getKey(), entry.getValue());
    }

    public Buyer(int number) {
        super("Buyer №" + number);
        Manager.buyerAddToShop();
    }

    Buyer(int number, boolean elderMark) {
        super("Buyer (Pensioneer) №" + number);
        setElderMark(elderMark);
        Manager.buyerAddToShop();
    }

    @Override
    public void run() {
        enterToMarket();
        takeCart();
        chooseGoods();
        putGoodsToCart();
        goToQueue();
        returnCart();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to shop");
        globalCount++;
    }

    @Override
    public void takeCart() {
        int timeout = Utils.getRandom(0, 2);
        System.out.println(this + " takes cart");
        if (isElderMark()) {
            Utils.waitForSeconds(timeout * ELDER_COEF);
        } else {
            Utils.waitForSeconds(timeout);
        }
        cart = new Cart();
    }

    @Override
    public void chooseGoods() {
        int timeout = Utils.getRandom(0, 2);
        System.out.println(this + " started to choose goods");
        if (isElderMark()) {
            Utils.waitForSeconds(timeout * ELDER_COEF);
        } else {
            Utils.waitForSeconds(timeout);
        }

        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void putGoodsToCart() {
        System.out.println(this + " puts goods to cart: ");
        //Map<String, Integer> tmp = new HashMap<>();
        int index = 0;
        String key;
        int val;
        for (Map.Entry<String, Integer> entry : Utils.gethMapOfGoods().entrySet()) {
            if (Utils.getRandom(0, 4) == index) {
                continue;
            } else if (index == 4) {
                break;
            }
            key = entry.getKey();
            val = entry.getValue();
            System.out.println(String.format("%s решил взять %s за %d р.", this, key, val));
            goods.put(key, val);
            index++;
        }
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            if (isElderMark()) {
                QueueBuyers.addElder(this);
            } else {
                QueueBuyers.add(this);

            }
            try {
                System.out.println(this + " added to queue");
                wait();///------------------------------------------------------------------------------------
                System.out.println(this + " leaves the queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public void returnCart() {
        int timeout = Utils.getRandom(0, 2);
        System.out.println(this + " returns cart");
        if (isElderMark()) {
            Utils.waitForSeconds(timeout * ELDER_COEF);
        } else {
            Utils.waitForSeconds(timeout);
        }
        cart.clearCart();
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the supermarket");
        Manager.buyerLeaveShop();
        globalCount--;
    }

    @Override
    public String toString() {
        return getName();
    }
}
