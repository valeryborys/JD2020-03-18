package by.it.akhmelev.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop opened");
        int number = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();

        while (Manager.shopOpened()) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.shopOpened() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Shop closed");
    }
}
