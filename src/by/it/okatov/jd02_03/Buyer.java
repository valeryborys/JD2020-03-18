package by.it.okatov.jd02_03;


class Buyer extends Thread implements IBuyer {
    //Семафор для раздачи корзинок


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
        chooseGoods();
        putGoodsToCart();
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
        //Utils.waitForSeconds(1);
        new Thread(CartsQueue.getCart(cart)).start();
    }


    @Override
    public void chooseGoods() {
        Utils.waitForSeconds(1);
        System.out.println(this + " started to choose goods");
        int timeout = Utils.getRandom(1, 2);
        Utils.waitForSeconds(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void putGoodsToCart() {

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
        System.out.println(this + " возвращает корзинку");
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
