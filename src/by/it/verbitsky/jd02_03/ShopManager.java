package by.it.verbitsky.jd02_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ShopManager extends Thread implements CashierStrings {
    private static final Object BUYER_MONITOR = new Object();
    private static final Object CASHIER_MONITOR = new Object();
    private static final Object TOTAL_SUM_MONITOR = new Object();

    private static final int PLAN = 100;
    public static final int MAX_CASHIER_COUNT = 5; // максимальное кол-во касс
    public static final int CASHIER_COUNT_FACTOR = 5; // кол-во покупателей на 1 кассу, при котором надо открывать еще 1
    private volatile static int inBuyerCount = 0;
    private volatile static int outBuyersCount = 0;
    private volatile double totalCash = 0;
    private Set<Cashier> cashiers = new HashSet<>();
    private List<Buyer> buyers = new ArrayList<>();


    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double checkSum) {
        synchronized (TOTAL_SUM_MONITOR) {
            this.totalCash += checkSum;
        }
    }

    public int getFreeCashierCount() {
        int count = 0;
        for (Cashier cashier : cashiers) {
            switch (cashier.getState()) {
                case WAITING: {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public void run() {
        ShopPrinter.printMessage("Start shop manager");
        while (outBuyersCount < PLAN) {
            //пока не обслужены все 100 покупателей, проверяем очередь покупателя
            //и следим за тем, чтобы покупателя было кому обслужить
            //проверим есть ли работающие кассы, и хватает ли их для обслуживания текущей очереди
            if (ShopQueue.getQueueCount() > 0) {
                //если есть доступные кассиры - значит будим одного
                if ((ShopQueue.getQueueCount() > (MAX_CASHIER_COUNT - getFreeCashierCount()) * CASHIER_COUNT_FACTOR)) {
                    for (Cashier cashier : cashiers) {
                        if (cashier.getState().equals(State.WAITING)) {
                            synchronized (cashier) {
                                cashier.notify();
                            }
                            break;
                        }
                    }
                }
            }
        }

        //все покупатели вышли, проверим что все кассы успели завершить свои потоки и находятся в состоянии WAITING
        //если касса будет в состоянии WAITING, то при запросе статуса от манагера получит команду завершить цикл опроса
        //и поток корректно завершиться
        ShopPrinter.printMessage("Stop cashiers");
        stopCashiersThreads();
        printFinishBlock();
    }

    private void printFinishBlock() {
        ShopPrinter.printMessage("\n\nAll buyers are served");
        ShopPrinter.printMessage("\nTotal cash = " + String.format("%6.2f", getTotalCash()));
        ShopPrinter.printMessage("\nAll cashiers are stopped:");
        ShopPrinter.printMessage(getCashiersStatus());
        ShopPrinter.printMessage("Possible to close the shop");
    }

    private void stopCashiersThreads() {
        int stopCount = 1;
        while (stopCount > 0) {
            stopCount = 0;
            for (Cashier cashier : cashiers) {
                switch (cashier.getState()) {
                    case WAITING:
                    case RUNNABLE:
                    case BLOCKED:
                    case TIMED_WAITING: {
                        stopCount++;
                        break;
                    }
                }
            }
            notifyAllCashiers();
            ShopPrinter.printMessage("Waiting until cashiers finish ...");
        }
    }

    private void notifyAllCashiers() {
        for (Cashier cashier : cashiers) {
            synchronized (cashier) {
                cashier.notify();
            }
        }
    }

    private String getCashiersStatus() {
        StringBuilder status = new StringBuilder();
        for (Cashier cashier : getCashiers()) {
            status.append(cashier.getName()).append(" ").append(cashier.getState().toString()).append("\n");
        }
        return status.toString();
    }

    public void printCashiersStatus() {
        StringBuilder text = new StringBuilder();
        for (Cashier cashier : cashiers) {
            text
                    .append(cashier.getName())
                    .append(" ")
                    .append(cashier.getState())
                    .append("\n");

        }
        ShopPrinter.printMessage(text.toString());
    }

    public void addBuyer(Buyer buyer) {
        synchronized (BUYER_MONITOR) {
            buyers.add(buyer);
            inBuyerCount++;
        }
    }

    public void removeBuyer(Buyer buyer) {
        synchronized (BUYER_MONITOR) {
            buyers.remove(buyer);
            outBuyersCount++;
        }
    }

    public boolean getStatusForCashier() {
        return outBuyersCount != PLAN;
    }

    public static int getOutBuyersCount() {
        return outBuyersCount;
    }

    public int getCurrentBuyersCount() {
        return inBuyerCount - outBuyersCount;
    }

    static boolean planCompleted() {
        return PLAN == outBuyersCount;
    }

    static boolean isShopOpen() {
        return inBuyerCount == PLAN;
    }

    public Set<Cashier> getCashiers() {
        return cashiers;
    }

    public static Object getCashierMonitor() {
        return CASHIER_MONITOR;
    }

    @Override
    public String toString() {
        return "ShopManager:";
    }
}
