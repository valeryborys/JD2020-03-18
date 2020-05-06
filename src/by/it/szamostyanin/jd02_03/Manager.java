package by.it.szamostyanin.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    static final int speed = 50;
    private static final int Plan = 100;    //количество покупателей
    private static final AtomicInteger inCount = new AtomicInteger(0);    //количество вошедших
    private static final AtomicInteger outCount = new AtomicInteger(0);   //количество обслуженных

    static boolean shopOpened() {                //что магазин открыт
        return inCount.get() < Plan;
    }

    static boolean planComplete() {              //что план выполнен
        return outCount.get() == Plan;
    }

    //синхронизация addBuyer на мониторе
    static void addBuyer() {
        inCount.getAndIncrement();
    }

    static void removeBuyer() {
        outCount.getAndIncrement();
    }
}