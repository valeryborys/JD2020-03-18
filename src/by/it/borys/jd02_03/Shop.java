package by.it.borys.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        Good.createGoods();
        System.out.println("Shop opened");
       // System.out.println("Cashier 1:  \t\t\t\t\t\tCashier 2:  \t\t\t\t\t\tCashier 3:  \t\t\t\t\t\tCashier 4:  \t\t\t\t\t\tCashier 5:  \t\t\t\t\t\tQueue Length: \tTotal:");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int number = 0;

        while (Manager.shopOpen()){
            if (Cashier.getCashiersOpened() < QueueBuyers.getCashNeed()){
                Cashier cashier = new Cashier(Cashier.getCashiersOpened()+1);
                threadPool.execute(cashier);
            }
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.shopOpen() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();

            }

            Helper.sleep(1000);
            //Manager.graph.put(time, Manager.count);
            }
        threadPool.shutdown();
        try {while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)){

        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Shop closed");
        //Manager.printToFile();
    }
}
