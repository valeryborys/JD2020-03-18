package by.it.gutkovsky.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    static final int K_SPEED = 100;
//    static final Object MONITOR_CASHIERS = new Object();

    // block for checking / controlling customers quantity
    private static final int PLAN = 100;
    private static final AtomicInteger comeIn = new AtomicInteger(0);
    private static final AtomicInteger comeOut = new AtomicInteger(0);

    public static int getComeIn() {
        return comeIn.get();
    }

    static boolean shopOpen() {
        return comeIn.get() < PLAN;
    }

    static boolean planComplete() {
        return comeIn.get() == PLAN;
    }

    static void customerComeIn() { // increasing quantity of buyers, when new buyer comes
        comeIn.getAndIncrement();
    }

    static void customerComeOut() { // decreasing quantity of buyers, when buyer left
        comeOut.getAndIncrement();
    }

    static boolean allCustomersCameOut() {
        return comeOut.get() == comeIn.get();
    }

    static int checkingQuantityInShop() { // temporary method for checking
        return comeIn.get() - comeOut.get();
    }

    static void openCashier() {
//        synchronized (MONITOR_CASHIERS) {
            if (QueueBuyers.queueSize() != 0 && QueueCashier.waitingStaff() != 0) {
                int openCashiers = (QueueBuyers.queueSize() - 1) / 5 + 1; // number of cashiers which should be opened
                int workCashiers = 5 - QueueCashier.waitingStaff(); // number of cashiers who are working now
                for (int i = 0; i < (openCashiers - workCashiers); i++) {
                    Cashier openCashier = QueueCashier.getStaff();
                    if (openCashier != null) {
                        System.out.println(openCashier + " opens after the rest");
                        synchronized (openCashier) {
                            openCashier.notify();
                        }
                    }
                }

            }
//        }
    }

    static boolean closeCashier() {
        return (QueueBuyers.queueSize() == 0 || ((QueueBuyers.queueSize()) / 5 + 1) < (5 - QueueCashier.waitingStaff()));
    }


    static void closeTheShop() {
        if (planComplete() && allCustomersCameOut()) {
            for (Cashier openCashier : QueueCashier.queueStaff()) {
                synchronized (openCashier) {
                    openCashier.notify();
                }
            }
        }

    }


}
