package by.it.bobrovich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashier {
    private static Deque<Cashier> cashiers = new ArrayDeque<>();

    static synchronized void add(Cashier cashier) {
        cashiers.addLast(cashier);
    }

    static synchronized Cashier extact() {
        return cashiers.pollFirst();
    }

    static synchronized int getCashiers() {
        return cashiers.size();
    }

    static synchronized int getCurrentCashiers(){
        return Math.max(5 - cashiers.size(), 0);
    }
}
