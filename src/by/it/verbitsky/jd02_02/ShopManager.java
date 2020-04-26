package by.it.verbitsky.jd02_02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ShopManager extends Thread implements CashierStrings {
    private static final Object BUYER_MONITOR = new Object();
    private static final Object CASHIER_MONITOR = new Object();

    private static final int PLAN = 100;
    private static final int MAX_CASHIER_COUNT = 5; // максимальное кол-во касс
    private static final int CASHIER_COUNT_FACTOR = 5; // кол-во покупателей на 1 кассу, при котором надо открывать еще 1
    private volatile static int inBuyerCount = 0;
    private volatile static int outBuyersCount = 0;

    private volatile int availableCashes = 0; //простаивающие кассы


    private Set<Cashier> cashiers = new HashSet<>();
    private List<Buyer> buyers = new ArrayList<>();

    public int getAvailableCashes() {
        return availableCashes;
    }

    @Override
    public void run() {
        System.out.println("Запустили шоп манагера");
        while (outBuyersCount < 100) {
            //пока не обслужены все 100 покупателей, проверяем очередь покупателя
            //и следим за тем, чтобы покупателя было кому обслужить
            //проверим есть ли работающие кассы, и хватает ли их для обслуживания текущей очереди
            if (ShopQueue.getQueueCount() > 0) {
                //System.out.println("зашли в блок иф");
                //если есть доступные кассиры - значит будим одного
                if ((ShopQueue.getQueueCount() > (MAX_CASHIER_COUNT - availableCashes) * CASHIER_COUNT_FACTOR)) {
                    /* данный блок показывает состояние касс и общую инфо об очереди
                    System.out.println("число вышедших покупателей = " + outBuyersCount);
                    System.out.println("число покупателей в очереди = " +
                            ShopQueue.getQueueCount() +
                            "\nсостояние касс: " +
                            getCashiersStatus());
                    */
                    for (Cashier cashier : cashiers) {
                        if (cashier.getState().equals(State.WAITING)) {
                            System.out.println("пробуем будить кассу: " + cashier.getName());
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
        //и поток завершиться
        System.out.println("Останавливаем кассиров");
        stopCashiersThreads();

        System.out.println("Все покупатели обслужены \nВсе кассы остановлены:");
        System.out.println(getCashiersStatus());
        System.out.println("Можно закрывать магазин");
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
            notyfyAllCashiers();
            System.out.println("Ждем завершения работы кассиров ....");
        }
    }

    private void notyfyAllCashiers() {
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

    public void printFreeCashiers() {
        for (Cashier cashier : cashiers) {
            System.out.println(cashier.getName() + " " + cashier.getState());
        }
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

    //уменьшает кол-во простаивающих кассиров
    public void wakeUpCashier() {
        synchronized (CASHIER_MONITOR) {
            if (availableCashes > 0) {
                availableCashes--;
            }
        }
    }

    //увеличивает кол-во простаивающих кассиров
    public void sleepCashier() {
        synchronized (CASHIER_MONITOR) {
            if (availableCashes < MAX_CASHIER_COUNT) {
                availableCashes++;
            }
        }
    }

    public String getStatusForCashier() {
        if (outBuyersCount == 100) {
            return CashierStrings.END;
        }
        int count = ShopQueue.getQueueCount();
        if ((count > (MAX_CASHIER_COUNT - availableCashes) * CASHIER_COUNT_FACTOR)) {
            return CashierStrings.WORK;
        } else {
            return CashierStrings.SLEEP;
        }
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
