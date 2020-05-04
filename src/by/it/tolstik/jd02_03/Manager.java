package by.it.tolstik.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    static final double K_FOR_OLDER_PEOPLE = 1.5;

    private static final int PLAN = 100;
    private static final AtomicInteger IN_COUNT = new AtomicInteger(0);
    private static final AtomicInteger OUT_COUNT = new AtomicInteger(0);
    private static final AtomicInteger TOTAL_SUM = new AtomicInteger(0);

    static boolean shopOpen() {
        return IN_COUNT.get() < PLAN;
    }

    static boolean planComplete() {
        return OUT_COUNT.get() == PLAN;
    }

    static void buyerEnterToShop() {
        IN_COUNT.getAndIncrement();
    }

    static void buyerQuiteShop() {
        OUT_COUNT.getAndIncrement();
    }

    static int addToTotalSum(int sum) {
        int temp = TOTAL_SUM.get();
        temp += sum;
        return TOTAL_SUM.getAndSet(temp);
    }

    static int getTotalSum() {
        System.out.println("Сумма выручки магазина: " + TOTAL_SUM.get() + " рублей.");
        return TOTAL_SUM.get();
    }
}
