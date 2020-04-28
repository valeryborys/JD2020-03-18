package by.it.lemesh.jd02_02;

public class Manager {
    static final int K_SPEED = 10;
    static final Object MONITOR = new Object();
    static final Object MONITOR_QUEUE = new Object();
    static final Object MONITOR_CASH = new Object();
    private static final int PLAN = 100;
    private volatile static int inCount = 0;
    private volatile static int outCount = 0;
    private volatile static int cash = 0;

    static boolean marketIsOpen() {
        return inCount < PLAN;
    }

    static boolean planComplete() {
        return outCount == PLAN;
    }

    static void buyerIn() {
        synchronized (MONITOR) {
            inCount++;
        }
    }

    static void BuyerOut() {
        synchronized (MONITOR) {
            outCount++;
        }
    }

    static int cashReport(int money) {
        synchronized (MONITOR_CASH) {
            cash += money;
            return cash;
        }
    }

    static void cashierControl() {
        if (!planComplete()) {
            synchronized (MONITOR_QUEUE) {
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
            Helper.sleep(1000);
        }
    }

    static boolean needToClose() {
        synchronized (MONITOR_QUEUE) {
            int queueCashiersSize = QueueCashiers.deque.size();
            int queueBuyersSize = QueueBuyers.deque.size();
            return (queueBuyersSize == 0) || (queueBuyersSize / 5 + 1 < 5 - queueCashiersSize);
        }
    }

    public static void closeTheMarket() {
        for (Cashier cashier : QueueCashiers.deque) {
            synchronized (cashier) {
                cashier.notify();
            }
        }
    }
}