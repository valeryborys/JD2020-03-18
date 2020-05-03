package by.it.tolstik.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args) {


        System.out.println("Магазин открылся");
        int time = 0;
        int number = 0;

        List<Thread> threads = new ArrayList<>();
        while (Manager.shopOpen()) {
            synchronized (QueueBuyers.MONITOR) {
                if (Cashier.getCashiersOpened() < QueueBuyers.getCashNeed()) {
                    Cashier cashier = new Cashier(Cashier.getCashiersOpened() + 1);
                    Thread thread = new Thread(cashier);
                    threads.add(thread);
                    thread.start();
                }
            }

            Buyer buyer = new Buyer(++number);
            buyer.start();
            threads.add(buyer);
            time++;
            if (time <= 10) Helper.sleep(3000, 100);
            else if (time <= 50) Helper.sleep(1000, 100);
            else if (time <= 60) Helper.sleep(3000, 100);
            else Helper.sleep(1000, 100);
        }
        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
            }
        }
        Manager.getTotalSum();
        System.out.println("Магазин закрылся. Кол-во посетителей: " + number);
    }


}



