package by.it.tolstik.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    static final Deque<Buyer> deque = new ArrayDeque<>();

    static synchronized  void add(Buyer buyer) {
        deque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return deque.pollFirst();
    }
}
