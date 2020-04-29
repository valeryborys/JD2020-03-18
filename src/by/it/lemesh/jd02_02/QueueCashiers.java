package by.it.lemesh.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashiers {
    static Deque<Cashier> deque = new ArrayDeque<>();

    static synchronized void addCashierToQueue(Cashier cashier) {
        deque.addLast(cashier);
    }

    static synchronized Cashier extractCashier() {
        return deque.pollFirst();
    }

    static synchronized int getLength() {
        return deque.size();
    }

}
