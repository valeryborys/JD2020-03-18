package by.it.gutkovsky.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Shop {
    public static void main(String[] args) {

        System.out.println("shop is opened");

//        Map<Integer, Integer> mapForChecking = new HashMap<>(); // temporary map for checking/testing the program

        int number = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        threadPool.shutdown();

        // число покупателей изменялось - менее 10 в начале каждой минуты и от 30 до 40 на 30 секунде каждой минуты.
        int timeFactor;
        while (Manager.shopOpen()) {
            for (int time = 0; time < 120; time++) {
                int count; // quantity of buyers that will enter to the shop
                timeFactor = time / 60; // correction timeFactor for different periods of time: solution will be the same even if will increase time period

                if (((60 * timeFactor) <= time) && (time <= (30 + 60 * timeFactor)) && Manager.shopOpen()) {
                    if (Manager.checkingQuantityInShop() < ((time - (60 * timeFactor)) + 10)) {
                        if (Manager.getComeIn() < 96) {
                            count = (time - 60 * timeFactor) + 5 - Manager.checkingQuantityInShop();
                            for (int i = 0; i < count; i++) {
                                number++;
                                threads.add(createCustomer(number, threads));
                            }
                        } else {
                         count = 100 - Manager.getComeIn();
                            for (int i = 0; i < count; i++) {
                                number++;
                                threads.add(createCustomer(number, threads));
                            }
                        }
                    }
                }
                if (time > (30 + (timeFactor * 60)) && time < (60 + (timeFactor * 60)) && Manager.shopOpen()) {
                    if (Manager.checkingQuantityInShop() < (40 + (30 - (time - (60 * timeFactor))))) {
                        if (Manager.getComeIn() < 96) {
                            count = (35 + (30 - (time - (60 * timeFactor)))) - Manager.checkingQuantityInShop();
                            for (int i = 0; i < count; i++) {
                                number++;
                                threads.add(createCustomer(number, threads));
                            }
                        } else {
                           int  countI = 100 - Manager.getComeIn();
                            count = Helper.getRandom(1, countI);
                            for (int i = 0; i < count; i++) {
                                number++;
                                threads.add(createCustomer(number, threads));
                            }
                        }
                    }
                }
//                mapForChecking.put(time, Manager.checkingQuantityInShop()); // temporary method method that helping to test
                Manager.openCashier();
                Helper.sleep(1000);
            }
        }

        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total revenue per working day: " + Cashier.getTotalSum() + "BYN");
        System.out.println("Shop is closed");

        // testing block
//        ForTesting.printingMap(mapForChecking);
    }

    /**
     * Method for creating new buyers and starting new thread
     *
     * @param number  - customer serial number
     * @param threads - list which contains all buyers, necessary that make join for all threads
     * @return - returns: a new buyer
     */
    static Buyer createCustomer(int number, List<Thread> threads) {
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
