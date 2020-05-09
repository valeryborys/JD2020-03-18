package by.it.tolstik.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    public final static Object MONITOR = new Object();
    private static int cashiersNeeded = 0;

    static final Deque<Buyer> dequeUsualBuyers = new ArrayDeque<>();
    static final Deque<Buyer> dequeForPensioner = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        dequeUsualBuyers.addLast(buyer);
        setCashiers();
    }

    static synchronized void addPens(Buyer buyer) {
        dequeForPensioner.addLast(buyer);
        setCashiers();
    }

    static synchronized Buyer extract() {
        return dequeUsualBuyers.pollFirst();
    }

    static synchronized Buyer extractPens() {
        return dequeForPensioner.pollFirst();
    }


    public static int getCashNeed() {
        return cashiersNeeded;
    }

    private static void setCashiers() {
        if ((dequeUsualBuyers.size() + dequeForPensioner.size()) == 0) cashiersNeeded = 0;
        else if ((dequeUsualBuyers.size() + dequeForPensioner.size()) <= 5) cashiersNeeded = 1;
        else if ((dequeUsualBuyers.size() + dequeForPensioner.size()) <= 10) cashiersNeeded = 2;
        else if ((dequeUsualBuyers.size() + dequeForPensioner.size()) <= 15) cashiersNeeded = 3;
        else if ((dequeUsualBuyers.size() + dequeForPensioner.size()) <= 20) cashiersNeeded = 4;
        else cashiersNeeded = 5;
    }
}
