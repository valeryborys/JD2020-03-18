package by.it.okatov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {
    private static final int PLAN = 100;

    private static final AtomicInteger inCount = new AtomicInteger(0);
    private static final AtomicInteger outCount = new AtomicInteger(0);


    static boolean supermarketOpened() {
        return inCount.get() < PLAN;
    }

    static boolean planComplete() {
        return outCount.get() == PLAN;
    }

    static void buyerAddToSupermarket() {
        inCount.getAndIncrement();
    }

    static void buyerLeavesSupermarket() {
        outCount.getAndIncrement();
    }
}






























