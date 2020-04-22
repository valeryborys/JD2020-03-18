package by.it.gutkovsky.jd02_01;

class Buyer extends Thread implements IBuyer {
    public Buyer(int number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
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

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this + "finished to choose goods");

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
