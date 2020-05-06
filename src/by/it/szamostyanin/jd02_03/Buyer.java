package by.it.szamostyanin.jd02_03;

import by.it.szamostyanin.jd02_02.IUseBasket;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitState = false;  //заводим признак
    public void setWaitState(boolean waitState) {
        this.waitState = waitState;
    }

    public Buyer(int number) {
        super("Buyer №"+number+" ");
        Manager.addBuyer(); //сразу учитывается
    }

    @Override
    public void run() {
        enterToMarket();
        //takeBasket();
        chooseGoods();
        toQueue();
        //putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"entered into the shop");
    }

    @Override
    public void takeBasket() {
        System.out.println(" "+this+"took the basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println("  "+this+"began choosing");
        int timeout= Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        System.out.println("  "+this+"finished choosing");
    }

    @Override
    public void toQueue() {
        synchronized (this){
        QueueBuyers.add(this);
        waitState=true;
        while (waitState)
            try {
                System.out.println("   "+this+"added to queue");
                this.wait();
                System.out.println("   "+this+"left the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this+"put the goods in the basket");
    }

    @Override
    public void goOut() {
        System.out.println(this+"left the shop");
        Manager.removeBuyer();
    }

    @Override
    public String toString() {
        return getName();
    }
}