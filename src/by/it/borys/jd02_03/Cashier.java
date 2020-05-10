package by.it.borys.jd02_03;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Cashier implements Runnable {
    private final int number;
    private AtomicBoolean needOpened = new AtomicBoolean(true);
    private static AtomicInteger cashiersOpened = new AtomicInteger(0);
    private String name;
    private static AtomicInteger totalCashPerDay = new AtomicInteger(0);

    Cashier(int number) {
        name = "\tCashier №" + number + ": ";
        this.number = number;
    }

    @Override
    public void run() {

        System.out.println(this + " opened");
        cashiersOpened.getAndIncrement();
        while (!Manager.planComplete() && needOpened.get()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                printCheck(buyer);
                int timeout = Helper.getRandom(2000, 5000);
                Helper.sleep(timeout);
                synchronized (buyer) {
                    buyer.setWaitState(false);
                    buyer.notify();
                    System.out.flush();
                }
            }
            if (cashiersOpened.get() > QueueBuyers.getCashNeed()) needOpened.set(false);
        }
        System.out.println(this + " closed");
        cashiersOpened.getAndDecrement();
    }

    public static int getCashiersOpened() {
        return cashiersOpened.get();
    }

    @Override
    public String toString() {
        return name;
    }

    private static void printTabs(int number) {
        for (int i = 0; i < (number - 1) * 9; i++) {
            System.out.print("\t");

        }
    }

    void printCheck(Buyer buyer) {
        synchronized (System.out) {
            AtomicInteger total = new AtomicInteger(0);
            printTabs(number);
            System.out.println("start to service " + buyer);
            HashMap<String, Integer> goods = buyer.basket.takeFromBasket();
            for (Map.Entry<String, Integer> good : goods.entrySet()) {
                printTabs(number);
                System.out.println("checked $ " + good.getValue() + " for " + good.getKey());
                total.addAndGet(good.getValue());
            }
            totalCashPerDay.addAndGet(total.get());
            printTabs(number);
            System.out.println("Total payment for " + buyer + " = " + total + "$");
            printTabs(number);
            System.out.println("finished to service " + buyer);
            printTabs(6);
            System.out.println(QueueBuyers.getQueueSize());
            printTabs(6);
            System.out.print("\t\t\t\t\t");
            System.out.println(totalCashPerDay);

        }
    }
}
