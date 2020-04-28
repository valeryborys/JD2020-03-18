package by.it.okatov.jd02_02.Test;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    static final Object GET_MONITOR = new Object();

    private static final int PLAN = 100;
    private volatile static int inCount = 0;
    private volatile static int outCount = 0;

    static boolean shopOpened() {
        return inCount < PLAN;
    }

    static boolean planComplete() {
        return outCount == PLAN;
    }

    static void buyerAddToShop() {
        synchronized (GET_MONITOR) {
            inCount++;
        }
    }

    static void buyerLeaveShop() {
        synchronized (GET_MONITOR) {
            outCount++;
        }
    }

    static int currentQueueSize() {
        synchronized (GET_MONITOR) {
            return inCount - outCount;
        }
    }


    synchronized static void manageCashBoxes(List<Cashier> cashierList) {
        List<Cashier> active = new ArrayList<>();
        if (inCount - outCount <= 5) {
        } else if (inCount - outCount <= 10) {
            active.add(cashierList.get(1).setActive());
        } else if (inCount - outCount <= 15) {
            active.add(cashierList.get(2).setActive());
        } else if (inCount - outCount <= 20) {
            active.add(cashierList.get(3).setActive());
        } else {
            active.add(cashierList.get(4).setActive());
        }

    }
}
