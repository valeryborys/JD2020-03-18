package by.it.okatov.jd02_02;


class Manager {

    private static final int PLAN = 100;

    private static final Object MONITOR = new Object();

    //Просто так без синхронизации обращаться к переменным inCount и outCount - нельзя
    //Потому что в какой-то момент разные потоки могут одновременно прочитать и
    //записать туда данные.
    private volatile static int inCount = 0;
    private volatile static int outCount = 0;


    static boolean supermarketOpened() {
        return inCount < PLAN;
    }

    static boolean planComplete() {
        return outCount == PLAN;
    }

    static void addBuyer() {
        synchronized (MONITOR) {
            inCount++;
        }
    }

    static void removeBuyer() {
        synchronized (MONITOR) {
            outCount++;
        }
    }
}


































