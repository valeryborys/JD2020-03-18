package by.it.novikov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int K_SPEED=100;


    private  static final AtomicInteger numberBuyer= new AtomicInteger(0);
    private  static final AtomicInteger buyersInMarket= new AtomicInteger(0);
    private  static final AtomicInteger comleteBuyers= new AtomicInteger(0);
    private static final int PLAN=100;

    static int getNumberBuyer(){return numberBuyer.get();}

    static void newBuyer(){
        numberBuyer.getAndIncrement();
        buyersInMarket.getAndIncrement();
    }

    static  void buyerLeaveTheMarket(){
        buyersInMarket.getAndDecrement();
        comleteBuyers.getAndDecrement();
    }

    static  boolean marketIsOpened(){return comleteBuyers.get()+ buyersInMarket.get()<PLAN;}
    static  boolean marketClosed(){return PLAN==comleteBuyers.get();}
}