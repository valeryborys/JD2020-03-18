package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop opened");
        int number = 0;

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Manager.shopOpened()) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.shopOpened() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000);
        }
        Helper.sleep(2000);
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
    }
}
