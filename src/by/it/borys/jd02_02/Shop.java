package by.it.borys.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
   // public static long starttime;
    public static void main(String[] args) {
       // starttime = System.nanoTime();
        Good.createGoods();
        System.out.println("Shop opened");
        System.out.println("Cashier 1:  \t\t\t\t\t\tCashier 2:  \t\t\t\t\t\tCashier 3:  \t\t\t\t\t\tCashier 4:  \t\t\t\t\t\tCashier 5:  \t\t\t\t\t\tQueue Length: \tTotal:");

        int number = 0;
        List<Thread> threads = new ArrayList<>();
//        for (int i = 1; i <=5 ; i++) {
//        }
        while (Manager.shopOpen()){
            synchronized (QueueBuyers.MONITOR){
            if (Cashier.getCashiersOpened() < QueueBuyers.getCashNeed()){
                Cashier cashier = new Cashier(Cashier.getCashiersOpened()+1);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            }
            }
       // for (int time = 0; time < 120; time++) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.shopOpen() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000);
            //Manager.graph.put(time, Manager.count);
            }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
        //Manager.printToFile();
    }
}
