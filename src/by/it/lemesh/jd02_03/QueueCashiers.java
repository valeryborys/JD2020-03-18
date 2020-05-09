package by.it.lemesh.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCashiers {
//    static Deque<Cashier> deque = new ArrayDeque<>();
    static BlockingDeque<Cashier> lbDeque = new LinkedBlockingDeque<>();

    static void addCashierToQueue(Cashier cashier) {
        try {
            lbDeque.putLast(cashier);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Cashier extractCashier() {
        return lbDeque.pollFirst();
    }

    static int getLength() {
        return lbDeque.size();
    }
}