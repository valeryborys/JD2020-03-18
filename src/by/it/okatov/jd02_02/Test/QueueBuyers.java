package by.it.okatov.jd02_02.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

    private static final Deque<Buyer> queue = new ArrayDeque<>();
    private static final Deque<Buyer> queueElders = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        queue.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return queue.pollFirst();
    }

    static synchronized void addElder(Buyer buyer) {
        queueElders.addLast(buyer);
    }

    static synchronized Buyer extractElder() {
        return queueElders.pollFirst();
    }

}
