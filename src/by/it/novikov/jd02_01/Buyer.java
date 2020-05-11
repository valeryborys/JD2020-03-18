package by.it.novikov.jd02_01;

class Buyer extends Thread implements IBuyer {
    Buyer(int number){super("Buyer № "+ number);}

    @Override
    public void run(){
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"enter to the Market");
    }


    @Override
    public void chooseGoods() {
        System.out.println(this+" starting choosing goods");
        int timeout = Helper.random(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+" finished choosing goods");

    }


    @Override
    public void goOut() {
        System.out.println(this+" leave the Market");
        Dispatcher.comleteBuyer++;

    }

    @Override
    public String toString() {
        return this.getName();
    }
}