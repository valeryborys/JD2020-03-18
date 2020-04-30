package by.it.tolstik.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args) {
        System.out.println("Магазин открылся");
        int number = 0;

        List<Thread> threads = new ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                Cashier cashier = new Cashier(i);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            }

        while (Manager.shopOpen()) {
            int count = Helper.getRandom(0,2);
            for (int i = 0; Manager.shopOpen() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000,100);
        }

        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Магазин закрылся. Кол-во посетителей: " + number);
    }
}


