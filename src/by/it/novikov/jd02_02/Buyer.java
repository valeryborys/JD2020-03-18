package by.it.novikov.jd02_02;

class Buyer extends Thread implements IBuyer {
    Buyer(int number){super("Buyer № "+ number);
    Dispatcher.newBuyer();}

    @Override
    public void run(){
        enterToMarket();
        chooseGoods();
        goOut();
        goToQueue();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the Market");
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
        Dispatcher.buyerLeaveTheMarket();

    }

    @Override
    public void goToQueue() {
        System.out.println(this+" queued");
        synchronized (this){
            try{
                QueueBuyers.add(this);
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();

            }
        }

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
