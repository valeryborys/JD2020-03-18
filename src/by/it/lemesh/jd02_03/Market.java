package by.it.lemesh.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Market {
    private static Semaphore semaphore = new Semaphore(20);

    public static void main(String[] args) {

        System.out.println("Market is open");
        Helper.printReport();
        Helper.fillMarketWithGoods();
        Baskets.createBaskets();
        String pensioner = "";
        int number = 0;
        int time = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();

        while (Manager.marketIsOpen()) {
            int count = Helper.getRandom(0, Helper.getCount(time++));
            for (int i = 0; Manager.marketIsOpen() && i < count; i++) {
                if (number % 4 == 0) pensioner = " (p)";
                Buyer buyer = new Buyer(++number, pensioner, semaphore);
                buyer.start();
                pensioner = "";
            }

            Helper.sleep(999);
        }

        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Market is closed");
    }
}
