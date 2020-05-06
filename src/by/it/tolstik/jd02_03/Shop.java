package by.it.tolstik.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Shop {
    public static void main(String[] args) {

        System.out.println("Магазин открылся");

        Backet.initializationBacket();

        int time = 0;
        int number = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        while (Manager.shopOpen()) {
            if (Cashier.getCashiersOpened() < QueueBuyers.getCashNeed()) {
                Cashier cashier = new Cashier(Cashier.getCashiersOpened() + 1);
                threadPool.execute(cashier);
            }

            Buyer buyer = new Buyer(++number);
            buyer.start();
            time++;
            if (time <= 10) Helper.sleep(3000, 100);
            else if (time <= 50) Helper.sleep(1000, 100);
            else if (time <= 60) Helper.sleep(3000, 100);
            else Helper.sleep(1000, 100);

        }

        threadPool.shutdown();

        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Manager.getTotalSum();
        System.out.println("Магазин закрылся. Кол-во посетителей: " + number);
    }
}



