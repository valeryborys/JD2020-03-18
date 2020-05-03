package by.it.okatov.jd02_03;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Manager {
    private static final int PLAN = 100;

    private static final AtomicInteger inCount = new AtomicInteger(0);
    private static final AtomicInteger outCount = new AtomicInteger(0);

    public static int inOut = inCount.get() - outCount.get();

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

    synchronized static void manageCashBoxes(List<Cashier> cashiers) {
        //cashiers.forEach(Cashier::deactivate);
        int in = inCount.get();
        int out = outCount.get();
        /*if (in-out <= 5) {
            cashiers.get(0).setActive();
        } else*/
        if (in - out > 5) {
            if (in - out <= 10) {
                cashiers.get(1).setActive();
            } else if (in - out <= 15) {
                cashiers.get(2).setActive();
            } else if (in - out <= 20) {
                cashiers.get(3).setActive();
            } else if (in - out >= 21) {
                cashiers.get(4).setActive();
            }
        }

    }
}






























