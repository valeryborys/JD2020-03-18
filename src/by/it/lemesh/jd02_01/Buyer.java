package by.it.lemesh.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean pensioner;
    private String pens = "";
    volatile static Integer buyersOnline = 0;

    public Buyer(int number, boolean pensioner) {
        super("Buyer №:" + number + " ");
        this.pensioner = pensioner;
        if (pensioner) pens = "(pensioner)";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        synchronized (buyersOnline) {
            buyersOnline++;
        }
        System.out.println(this + pens + " enter to market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + pens + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        int countOfGoods = Helper.getRandom(1, 4);
        for (int i = 0; i < countOfGoods; i++) {
            String good = Helper.takeAGood();
            System.out.println(this + pens + " " + good);
            int timeOut = Helper.getRandom(500, 2000);
            if (pensioner) timeOut = (int) (timeOut * 1.5);
            Helper.sleep(timeOut);
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + pens + " begin to choose goods");
        putGoodsToBasket();
        System.out.println(this + pens + " has finished choosing goods");
    }

    @Override
    public void goOut() {
        synchronized (buyersOnline) {
            buyersOnline--;
        }
        System.out.println(this + pens + " exit market");
    }

    @Override
    public String toString() {
        return getName();
    }
}
