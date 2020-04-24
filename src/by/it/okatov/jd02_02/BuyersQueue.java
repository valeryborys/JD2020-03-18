package by.it.okatov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class BuyersQueue {

    private static final Deque<Buyer> buyerDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        buyerDeque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return buyerDeque.pollFirst();
    }
}



















