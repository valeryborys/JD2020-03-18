package by.it.okatov.jd02_03;

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

        /*if (inCount - outCount <= 5) {
        } else*/
        if (inCount - outCount <= 10) {
            cashierList.get(1).setActive();
        } else if (inCount - outCount <= 15) {
            cashierList.get(2).setActive();
        } else if (inCount - outCount <= 20) {
            cashierList.get(3).setActive();
        } else {
            cashierList.get(4).setActive();
        }

    }

    synchronized static int getBuyersRange(int pseudoTime) {
        int count = Buyer.globalCount.get();
        Utils.forPrinting.put(pseudoTime, count);
        pseudoTime %= 30;
        if (pseudoTime <= 15 && count < pseudoTime + 5) {
            return Utils.getRandom(0, pseudoTime + 5 - count);
        } else if (pseudoTime > 15 && count <= 41 - pseudoTime) {
            return Utils.getRandom(0, 41 - pseudoTime - count);
        } else {
            return 0;
        }
    }
}
