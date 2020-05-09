package by.it.lemesh.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market is open");
        Helper.printReport();
        Helper.fillMarketWithGoods();
        String pensioner = "";
        int number = 0;
        int time = 0;
        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            list.add(thread);
            thread.start();
        }
        while (Manager.marketIsOpen()) {
            int count = Helper.getRandom(0,Helper.getCount(time++));
            for (int i = 0; Manager.marketIsOpen() && i < count; i++) {
                if (number % 4 == 0) pensioner = " (p)";
                Buyer buyer = new Buyer(++number, pensioner);
                buyer.start();
                list.add(buyer);
                pensioner = "";
            }

            Helper.sleep(999);
        }
        for (Thread t : list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market is closed");
    }
}
