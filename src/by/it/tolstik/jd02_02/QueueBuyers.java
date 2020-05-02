package by.it.tolstik.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    public final static Object MONITOR = new Object();
    private static int cashiersNeeded = 0;

    static final Deque<Buyer> deque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        deque.addLast(buyer);
        setCashiers();
    }

    static synchronized Buyer extract() {
        return deque.pollFirst();
    }

    public static int getCashNeed() {
        return cashiersNeeded;
    }

    private static void setCashiers() {
        if (deque.size() == 0) cashiersNeeded = 0;
        else if (deque.size() <= 5) cashiersNeeded = 1;
        else if (deque.size() <= 10) cashiersNeeded = 2;
        else if (deque.size() <= 15) cashiersNeeded = 3;
        else if (deque.size() <= 20) cashiersNeeded = 4;
        else cashiersNeeded = 5;
    }
}
