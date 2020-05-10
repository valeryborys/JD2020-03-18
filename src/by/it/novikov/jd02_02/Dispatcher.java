package by.it.novikov.jd02_02;

public class Dispatcher {
    static final int K_SPEED=100;

    static int numberBuyer=0;


    private volatile static int buyersInMarket=0;
    private volatile static int comleteBuyers=0;
    private static final int PLAN=100;

    synchronized static void newBuyer(){
        numberBuyer++;
        buyersInMarket++;
    }
    synchronized  static  void buyerLeaveTheMarket(){
        buyersInMarket--;
        comleteBuyers++;
    }

    static boolean marketIsOpened(){return comleteBuyers+buyersInMarket<PLAN;}
    static  boolean marketIsClosed(){return PLAN==comleteBuyers;}
}