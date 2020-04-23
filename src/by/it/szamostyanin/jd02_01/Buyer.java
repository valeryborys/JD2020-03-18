package by.it.szamostyanin.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Buyer №"+number+" ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"entered into the shop");
    }

    @Override
    public void takeBasket() {
        System.out.println(this+"took the basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"began shopping");
        int timeout= Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this+"finished shopping");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this+"put the goods in the basket");
    }

    @Override
    public void goOut() {
        System.out.println(this+"left the shop");
    }

    @Override
    public String toString() {
        return getName();
    }
}