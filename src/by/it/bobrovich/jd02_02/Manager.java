package by.it.bobrovich.jd02_02;

import java.util.HashMap;

public class Manager {
    static final int K_SPEED = 100;
    static final Object MONITOR = new Object();
    static final Object CASHIER_MONITOR = new Object();
    static HashMap<String, Integer> goods = new HashMap<>();

    private static final int PLAN = 100;

    private volatile static int inCount = 0;
    private volatile static int outCount = 0;

    static boolean showOpened() {
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

    static void leaveBuyer() {
        synchronized (MONITOR) {
            outCount++;
        }
    }

    static int getInCount(){
        synchronized (MONITOR){
            return inCount;
        }
    }

    static void openCashier() {
        if (QueueCashier.getCashiers() > 0) {
            int count = QueueBuyers.getQueue() / 5;
            if (count > 5)
                count = 5;
            if (QueueCashier.getCurrentCashiers() > count) {
                count = 0;
            } else {
                count = count - QueueCashier.getCurrentCashiers();
            }
            for (int i = 0; i < count; i++) {
                Cashier cashier = QueueCashier.extact();
                synchronized (cashier) {
                    cashier.notify();
                }
            }
        }
    }

    //попробывать проверку на колличество полкупателей в очереде,
    //если один ---> слип на 5 сек либо здесь, либо в потоке
    static void closeCashiers() {
        if (QueueCashier.getCashiers() > 0) {
            Cashier cashier = QueueCashier.extact();
            synchronized (cashier) {
                cashier.notifyAll();
            }
        }
    }

    static {
        Goods milk = new Goods("Молоко", 100);
        Goods rice = new Goods("Рис", 150);
        Goods water = new Goods("Вода", 50);
        Goods coffee = new Goods("Кофе", 200);
        goods.put(milk.getName(), milk.getPrice());
        goods.put(water.getName(), water.getPrice());
        goods.put(rice.getName(), rice.getPrice());
        goods.put(coffee.getName(), coffee.getPrice());
    }
}
