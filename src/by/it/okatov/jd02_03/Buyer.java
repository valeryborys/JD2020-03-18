package by.it.okatov.jd02_03;



class Buyer extends Thread implements IBuyer {


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
        Manager.buyerLeavesSupermarket();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Utils.GLOBAL_COUNTER.getAndIncrement();
        System.out.println(this + "enter to shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Utils.getRandom(1, 2);
        Utils.waitForSeconds(timeout);
        System.out.println(this + "finished to choose goods");
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
    public void goOut() {
        Utils.GLOBAL_COUNTER.getAndDecrement();
        System.out.println(this + "leave the shop");
        Manager.buyerLeavesSupermarket();
    }

    @Override
    public String toString() {
        return getName();
    }
}
