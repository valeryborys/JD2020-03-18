package by.it.borys.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    private final static Object MONITOR2 = new Object();
    private boolean needOpened = true;
    private static int cashiersOpened =0;
    private String name;
    Cashier(int number) {
        name = "\tCashier №"+number+": ";
    }

    @Override
    public void run() {

        System.out.println(this + " opened");
        cashiersOpened++;
        while (!Manager.planComplete() && needOpened) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                int total = 0;
                synchronized (MONITOR2) {
                    System.out.println(this + " start to service " + buyer);
                    HashMap<String, Integer> goods = buyer.basket.takeFromBasket();
                    for (Map.Entry<String, Integer> good : goods.entrySet()) {
                        System.out.println(this + " checked $ " + good.getValue() + " for " + good.getKey());
                        total += good.getValue();
                    }
                    System.out.println(this + " finished to service " + buyer);
                    System.out.println("\tTotal payment for " + buyer + " = " + total + "$");
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
        cashiersOpened--;
        }

    public static int getCashiersOpened(){
        return cashiersOpened;
    }

    @Override
    public String toString() {
        return name;
    }
}
