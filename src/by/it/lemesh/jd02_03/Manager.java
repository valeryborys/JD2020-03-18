package by.it.lemesh.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    static final int K_SPEED = 10;
    static final Object MONITOR_QUEUE = new Object();
    private static final int PLAN = 100;
    final static AtomicInteger inCount = new AtomicInteger(0);
    final static AtomicInteger outCount = new AtomicInteger(0);
    final static AtomicInteger onlineCount = new AtomicInteger(0);
    final static AtomicInteger cash = new AtomicInteger(0);

    static boolean marketIsOpen() {
        return inCount.get() < PLAN;
    }

    static boolean planComplete() {
        return outCount.get() == PLAN;
    }

    static void buyerIn() {
        inCount.getAndIncrement();
        onlineCount.getAndIncrement();
    }

    static void BuyerOut() {
        outCount.getAndIncrement();
        onlineCount.getAndDecrement();
    }

    static int getOnlineBuyers() {
        return onlineCount.get();
    }

    static int cashReport(int money) {
        return cash.addAndGet(money);
    }

    static void cashierControl() {
        if (!planComplete()) {
            if (QueueBuyers.getLength() > 0) {
                int needCashier = QueueBuyers.getLength() / 5 + 1 - (5 - QueueCashiers.getLength());
                for (int i = 0; i < needCashier; i++) {
                    Cashier cashier = QueueCashiers.extractCashier();
                    if (cashier != null) {
                        System.out.println(cashier + " is open");
                        synchronized (cashier) {
                            cashier.notify();
                        }
                    }
                }
            }
        }
    }

    static boolean needToClose() {
        int queueCashiersSize = QueueCashiers.getLength();
        int queueBuyersSize = QueueBuyers.getLength();
        return (queueBuyersSize == 0) || (queueBuyersSize / 5 + 1 < 5 - queueCashiersSize);
    }

    public static void closeTheMarket() {
        for (Cashier cashier : QueueCashiers.lbDeque) {
            synchronized (cashier) {
                cashier.notify();
            }
        }
    }
}