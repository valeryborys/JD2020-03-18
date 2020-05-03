package by.it.borys.jd02_02;


import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    public final static Object MONITOR2 = new Object();
    private final int number;
    private boolean needOpened = true;
    private static volatile int cashiersOpened =0;
    private String name;
    private static volatile int totalShop=0;
    Cashier(int number) {
        name = "Cashier №"+number+": ";
        this.number = number;
    }

    @Override
    public void run() {

        System.out.println(this + " opened");
        synchronized (MONITOR2){
        cashiersOpened++;}
        while (!Manager.planComplete() && needOpened) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                int total = 0;
                synchronized (MONITOR2) {
                    printTabs(number);
                    System.out.println("start to service " + buyer);
                    HashMap<String, Integer> goods = buyer.basket.takeFromBasket();
                    for (Map.Entry<String, Integer> good : goods.entrySet()) {
                        printTabs(number);
                        System.out.println( "checked $ " + good.getValue() + " for " + good.getKey());
                        total += good.getValue();
                    }
                    totalShop+=total;
                    printTabs(number);
                    System.out.println("Total payment for " + buyer + " = " + total + "$");
                    printTabs(number);
                    System.out.println("finished to service " + buyer);
                    printTabs(6);
                    System.out.println(QueueBuyers.getQueueSize());
                    printTabs(6);
                    System.out.print("\t\t\t\t\t");
                    System.out.println(totalShop);
                    int timeout = Helper.getRandom(2000, 5000);
                    Helper.sleep(timeout);
                }
                synchronized (buyer) {
                    buyer.notify();
                    System.out.flush();
                }
            } //else Helper.sleep(100);//сделать что бы кассир засыпал/просыпался
       synchronized (QueueBuyers.MONITOR){
           if(cashiersOpened>QueueBuyers.getCashNeed()) needOpened=false;}
        }
        System.out.println(this + " closed");
        synchronized (MONITOR2){
            cashiersOpened--;}
        }

    public static int getCashiersOpened(){
        return cashiersOpened;
    }

    @Override
    public String toString() {
        return name;
    }
    private static synchronized void printTabs(int number){
        for (int i = 0; i <(number-1)*9 ; i++) {
            System.out.print("\t");

        }
    }
}
