package by.it.akhmelev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    static final int K_SPEED = 10;

    private static final int PLAN = 100;
    private static final AtomicInteger inCount = new AtomicInteger(0);
    private static final AtomicInteger outCount = new AtomicInteger(0);

    static boolean shopOpened() {
        return inCount.get() < PLAN;
    }

    static boolean planComplete() {
        return outCount.get() == PLAN;
    }

    static void buyerAddToShop() {
        inCount.getAndIncrement();
    }

    static void buyerLeaveShop() {
        outCount.getAndIncrement();
    }

}
