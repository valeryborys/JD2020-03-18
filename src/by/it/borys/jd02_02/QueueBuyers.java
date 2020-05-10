package by.it.borys.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    public final static Object MONITOR_QUEUE = new Object();
    private static Deque<Buyer> queue = new ArrayDeque<>();
    private volatile static int cashiersNeeded = 0;

    static void add(Buyer buyer) {
        synchronized (MONITOR_QUEUE) {
            queue.addLast(buyer);
            setCashiers();
            synchronized (Cashier.MONITOR_CASHIER) {
                if (Cashier.getCashiersOpened() < getCashiersNeed()) {
                    Manager.openCashier();
                }
            }
        }
    }

    static synchronized Buyer extract() {
        Buyer buyer=null;
//        synchronized (MONITOR_QUEUE){
//        for (Buyer b : queue) {
//            if (b.isPensioner()) {
//                buyer= b;
//                queue.remove(b);
//                break;
//            }
//        }
//        if (buyer == null){
            buyer = queue.pollFirst();
//        }
//        }
        setCashiers();
        return buyer;
    }

    private synchronized static void setCashiers() {
        if (queue.size() == 0) cashiersNeeded = 0;
        else if (queue.size() <= 5) cashiersNeeded = 1;
        else if (queue.size() <= 10) cashiersNeeded = 2;
        else if (queue.size() <= 15) cashiersNeeded = 3;
        else if (queue.size() <= 20) cashiersNeeded = 4;
        else cashiersNeeded = 5;
    }

    public static int getCashiersNeed() {
        synchronized (Cashier.MONITOR_CASHIER) {
            return cashiersNeeded;
        }
    }

    public synchronized static int getQueueSize() {
        return queue.size();
    }

}
