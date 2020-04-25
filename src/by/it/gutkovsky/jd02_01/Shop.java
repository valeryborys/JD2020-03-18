package by.it.gutkovsky.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Shop {
    public static void main(String[] args) {

        System.out.println("shop is opened");

//        Map<Integer, Integer> mapForChecking = new HashMap<>(); // temporary map for checking/testing the program

        int number = 0;
        List<Buyer> buyers = new ArrayList<>();
        int timeFactor;
        for (int time = 0; time < 120; time++) {
            int count; // quantity of buyers that will enter to the shop
            timeFactor = time / 60; // correction timeFactor for different periods of time: solution will be the same even if will increase time period

            if (((60 * timeFactor) <= time) && (time <= (30 + 60 * timeFactor))) {
                if (Manager.checkingQuantityInShop() < ((time - (60 * timeFactor)) + 10)) {
                    count = (time - 60 * timeFactor) + 10 - Manager.checkingQuantityInShop();
                    for (int i = 0; i < count; i++) {
                        number++;
                        buyers.add(creatCustomer(number, buyers));
                    }
                }
            }
            if (time > (30 + (timeFactor * 60)) && time < (60 + (timeFactor * 60))) {
                if (Manager.checkingQuantityInShop() < (40 + (30 - (time - (60 * timeFactor))))) {
                    count = (40 + (30 - (time - (60 * timeFactor)))) - Manager.checkingQuantityInShop();
                    for (int i = 0; i < count; i++) {
                        number++;
                        buyers.add(creatCustomer(number, buyers));
                    }
                }
            }
            // it was before start C part 2
//            count = Helper.getRandom(0, 2);
//            for (int i = 0; i < count; i++) {
//                number++;
//                buyers.add(creatCustomer(number, buyers));
//            }

//            mapForChecking.put(time, Manager.checkingQuantityInShop()); // temporary method method that helping to test
            Helper.sleep(1000);
        }

        Helper.sleep(2000);

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
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
     * @param buyers - list which contains all buyers, necessary that make join for all threads
     * @return - returns: a new buyer
     */
    static Buyer creatCustomer(int number, List<Buyer> buyers) {
        Buyer buyer;
        if ((buyers.size() % 4 != 0)) {
            buyer = new Buyer(number);
        } else {                                    // pensioner is coming
            buyer = new Buyer(number, true);
        }
        buyer.start();
        return buyer;
    }
}
