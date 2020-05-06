package by.it.szamostyanin.jd02_02;


public class Manager {
    static final int speed = 50;
    static final Object Monitor = new Object();   //создаем монитор, так как мы и читаем и добавляем и записываем одной операции
    private static final int Plan = 100;    //количество покупателей
    private static volatile int inCount = 0;    //количество вошедших
    private static volatile int outCount = 0;   //количество обслуженных

    static boolean shopOpened() {                //что магазин открыт
        return inCount < Plan;
    }

    static boolean planComplete() {              //что план выполнен
        return outCount == Plan;
    }

    /*static synchronized void addBuyer(){    //синхронизация метода, что бы небыло ошибки после увеличения покупателя
        inCount++;
    }*/

    //синхронизация addBuyer на мониторе
    static void addBuyer() {
        synchronized (Monitor) {
            inCount++;
        }
    }

    static void removeBuyer() {
        synchronized (Monitor) {
            outCount++;
        }
    }
}