package by.it.okatov.jd02_03;


import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer {
    //private static int permits = 20;


    private boolean isElder;

    public boolean isElder() {
        return this.isElder;
    }

    public void setElder(boolean isElder) {
        this.isElder = isElder;
    }

    private int number;

    int getNumber() {
        return this.number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    private static final float ELDER_COEF = 1.5f;

    private final Map<String, Integer> goods = new HashMap<>();

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map.Entry<String, Integer> entry) {
        this.goods.put(entry.getKey(), entry.getValue());
    }


    Buyer(int number) {
        super("Buyer №" + number);
        setNumber(number);
        Manager.buyerAddToSupermarket();
    }

    Buyer(int number, boolean elderMark) {
        super("Buyer (Pensioneer) №" + number);
        setElder(elderMark);
        setNumber(number);
        Manager.buyerAddToSupermarket();
    }

    private Cart cart;


    @Override
    public void run() {
        cart = new Cart(getNumber() % 50, this);
        enterToMarket();
        getCart();

        //----------------SEMAFORE----------------
        try {

            Utils.GOODS_SEMAFORE.acquire();
            System.out.println(this + " получил разрешение на выбор товаров!");
            chooseGoods();
            putGoodsToCart();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Utils.GOODS_SEMAFORE.release();
            System.out.println(this + " закончил выбор товаров и отдал разрешение!");

        }

        //----------------SEMAFORE----------------

        goToQueue();
        returnCart();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Utils.GLOBAL_COUNTER.getAndIncrement();
        System.out.println(this + " enters the supermarket");
    }

    @Override
    public void getCart() {
        int timeout = Utils.getRandom(0, 2);
        System.out.println(this + " takes cart");
        if (isElder()) {
            Utils.waitForSeconds(timeout * ELDER_COEF);
        } else {
            Utils.waitForSeconds(timeout);
        }
        new Thread(CartsQueue.getCart(cart)).start();
    }


    @Override
    public void chooseGoods() {
        int timeout = Utils.getRandom(1, 2);
        if (isElder()) {
            timeout *= ELDER_COEF;
        }
        Utils.waitForSeconds(1);
        System.out.println(this + " started to choose goods");

        Utils.waitForSeconds(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void putGoodsToCart() {
        System.out.println(this + " puts goods to cart: ");
        //Map<String, Integer> tmp = new HashMap<>();
        int index = 0;
        String key;
        int val;
        for (Map.Entry<String, Integer> entry : Utils.getMapOfGoods().entrySet()) {
            if (Utils.getRandom(0, 4) == index) {
                continue;
            } else if (index == 4) {
                break;
            }
            key = entry.getKey();
            val = entry.getValue();
            System.out.println(String.format("%s решил взять %s за %d р.", this, key, val));
            setGoods(entry);
            index++;
        }
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            BuyersQueue.add(this);
            try {
                System.out.println(this + " added to queue");
                wait();
                System.out.println(this + " leaves the queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void returnCart() {
        int timeout = Utils.getRandom(0, 2);
        System.out.println(this + " возвращает корзинку");
        if (isElder()) {
            timeout *= ELDER_COEF;
        }

        Utils.waitForSeconds(timeout);
        CartsQueue.returnCart();
        /*synchronized (cart)
        {
            cart.notify();
        }*/
        Utils.CARTS_SEMAPHORE.release();
    }

    @Override
    public void goOut() {
        Utils.GLOBAL_COUNTER.getAndDecrement();
        System.out.println(this + " leaves the supermarket");
        Manager.buyerLeavesSupermarket();
    }

    @Override
    public String toString() {
        return getName();
    }
}
