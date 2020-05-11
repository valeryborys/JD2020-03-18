package by.it.borys.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        Good.createGoods();
        System.out.println("Shop opened");
        System.out.println("Cashier 1:  \t\t\t\t\t\tCashier 2:  \t\t\t\t\t\tCashier 3:  \t\t\t\t\t\tCashier 4:  \t\t\t\t\t\tCashier 5:  \t\t\t\t\t\tQueue Length: \tTotal:");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int number = 0;

        while (Manager.shopOpen()) {
            for (int time = 0; time < 120; time++) {
                if (Cashier.getCashiersOpened() < QueueBuyers.getCashNeed()) {
                    Cashier cashier = new Cashier(Cashier.getCashiersOpened() + 1);
                    threadPool.execute(cashier);
                }
                int count = Helper.getRandom(0, Manager.buyersReg(time, Manager.inStoreRigthNow.get()));
                for (int i = 0; Manager.shopOpen() && i < count; i++) {
                    Buyer buyer;
                    buyer = Math.random() > 0.75 ? new Buyer(++number, true) : new Buyer(++number);
                    buyer.start();

                }

                Helper.sleep(1000);
                Manager.graph.put(time, Manager.inStoreRigthNow.get());}

        }
        threadPool.shutdown();
        try {while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)){

        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Shop closed");
        Manager.printToFile();
    }
}
