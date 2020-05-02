package by.it.tolstik.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueCashiers {

    static final Deque<Cashier> deque = new ArrayDeque<>();

    static synchronized  void add(Cashier cashier) {
        deque.addLast(cashier);
    }

    static synchronized Cashier extract() {
        return deque.pollFirst();
    }
}

