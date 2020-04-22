package by.it.gutkovsky.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket{
    public Buyer(int number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to shop");

    }

    @Override
    public void takeBacket() {
        System.out.println(this + "take a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
       int timeout = Helper.getRandom(500, 2000);

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this + "finished to choose goods");

    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this + "put goods to basket");

    }

    @Override
    public void goOut() {
        System.out.println(this + "get out from the shop");
    }

    @Override
    public String toString() {
        return getName();
    }
}
