package by.it.bobrovich.jd02_02;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {
        int number = 0;
        boolean isPensioneer = false;
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new Cashier(i));
            thread.start();
        }

        while (Manager.showOpened()) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.showOpened() && i < count; i++) {
                Buyer buyer = new Buyer(++number, isPensioneer);
                buyer.start();
                threads.add(buyer);
            }
            Manager.openCashier();
            Helper.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
    }


}
