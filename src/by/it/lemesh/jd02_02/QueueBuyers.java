package by.it.lemesh.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class QueueBuyers {
    static Deque<Buyer> deque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        deque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        Buyer pens = null;
        for (Buyer b : deque) {
            if (b.pensioner) {
                pens = b;
                break;
            }
        }
        if (pens == null) return deque.pollFirst();
        else {
            deque.remove(pens);
            return pens;
        }
    }

    static synchronized int getLength() {
        return deque.size();
    }
}
