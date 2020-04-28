package by.it.tolstik.jd02_02;

class Manager {

    static final double K_FOR_OLDER_PEOPLE = 1.5;

    static final Object MONITOR = new Object();

    private static final int PLAN = 100;
    private volatile static int IN_COUNT = 0;
    private volatile static int OUT_COUNT = 0;

    static boolean shopOpen() {
        return IN_COUNT < PLAN;
    }

    static boolean planComplete() {
        return OUT_COUNT == PLAN;
    }

    static void buyerEnterToShop() {
        synchronized (MONITOR) {
            IN_COUNT++;
        }
    }

    static void buyerQuiteShop() {
        synchronized (MONITOR) {
            OUT_COUNT++;
        }
    }


}
