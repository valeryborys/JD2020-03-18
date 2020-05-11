package by.it.borys.jd02_02;


import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    public final static Object MONITOR_CASHIER = new Object();
    private final int number;
    private volatile boolean needOpened = true;
    private static volatile int cashiersOpened = 0;
    private String name;
    private static volatile int totalCashPerDay = 0;

    Cashier(int number) {
        name = "Cashier №" + number + ": ";
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        synchronized (MONITOR_CASHIER) {
            cashiersOpened++;
        }
        while (!Manager.planComplete()&& needOpened) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                printCheck(buyer);
                int timeout = Helper.getRandom(2000, 5000);
                Helper.sleep(timeout);
                synchronized (buyer) {
                    buyer.notify();
                    System.out.flush();
                }
            }
            synchronized (MONITOR_CASHIER) {
                if (cashiersOpened > QueueBuyers.getCashiersNeed()) {
                    needOpened = false;
                    cashiersOpened--;
                }
                Manager.cashierQueue.addLast(this.number);
            }
        }
        System.out.println(this + " closed");
    }


    public static int getCashiersOpened() {
        synchronized (MONITOR_CASHIER) {
            return cashiersOpened;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    private static synchronized void printTabs(int number) {
        for (int i = 0; i < (number - 1) * 9; i++) {
            System.out.print("\t");

        }
    }

    void printCheck(Buyer buyer) {
        synchronized (System.out) {
            int total = 0;
            printTabs(number);
            System.out.println("start to service " + buyer);
            HashMap<String, Integer> goods = buyer.basket.takeFromBasket();
            for (Map.Entry<String, Integer> good : goods.entrySet()) {
                printTabs(number);
                System.out.println("checked $ " + good.getValue() + " for " + good.getKey());
                total += good.getValue();
            }
            totalCashPerDay += total;
            printTabs(number);
            System.out.println("Total payment for " + buyer + " = " + total + "$");
            printTabs(number);
            System.out.println("finished to service " + buyer);
            printTabs(6);
            System.out.println(QueueBuyers.getQueueSize());
            printTabs(6);
            System.out.print("\t\t\t\t\t");
            System.out.println(totalCashPerDay);

        }
    }
}
