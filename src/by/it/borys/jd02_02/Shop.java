package by.it.borys.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
   static volatile List<Thread> threads = new ArrayList<>();
    public static void main(String[] args) {
        Good.createGoods();
        System.out.println("Shop opened");
        System.out.println("Cashier 1:  \t\t\t\t\t\tCashier 2:  \t\t\t\t\t\tCashier 3:  \t\t\t\t\t\tCashier 4:  \t\t\t\t\t\tCashier 5:  \t\t\t\t\t\tQueue Length: \tTotal:");

        int number = 0;
        while (Manager.shopOpen()) {
            for (int time = 0; time < 120; time++) {
                    int count = Helper.getRandom(0, Manager.buyersReg(time, Manager.inStoreRigthNow));
                    for (int i = 0; Manager.shopOpen() && i <= count; i++) {
                        Buyer buyer = null;
                        buyer = Math.random() > 0.75 ? new Buyer(++number, true) : new Buyer(++number);
                        buyer.start();
                        threads.add(buyer);
                    }
                Helper.sleep(1000);
                    Manager.graph.put(time, Manager.inStoreRigthNow);


            }
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
        Manager.printToFile();
    }
}
