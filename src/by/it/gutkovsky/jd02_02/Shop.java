package by.it.gutkovsky.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args) {

        System.out.println("shop is opened");

//        Map<Integer, Integer> mapForChecking = new HashMap<>(); // temporary map for checking/testing the program

        int number = 0;
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <=5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Manager.shopOpen()) {
            for (int time = 0; time < 120; time++) {
                int count = Helper.getRandom(0, 2);
                for (int i = 0; Manager.shopOpen() && i < count; i++) {
                    number++;
                    threads.add(creatCustomer(number, threads));
                }
//            mapForChecking.put(time, Manager.checkingQuantityInShop()); // temporary method method that helping to test
                Helper.sleep(1000);
            }
        }

        Helper.sleep(2000);

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop is closed");

        // testing block
//        ForTesting.printingMap(mapForChecking);
    }

    /**
     * Method for creating new buyers and starting new thread
     *
     * @param number - customer serial number
     * @param threads - list which contains all buyers, necessary that make join for all threads
     * @return - returns: a new buyer
     */
    static Buyer creatCustomer(int number, List<Thread> threads) {
        Buyer buyer;
        if ((threads.size() % 4 != 0)) {
            buyer = new Buyer(number);
        } else {                                    // pensioner is coming
            buyer = new Buyer(number, true);
        }
        buyer.start();
        return buyer;
    }
}
