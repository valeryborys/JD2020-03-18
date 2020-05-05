package by.it.szamostyanin.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        System.out.println("=== Shop opened ===");
        int buyerNumber = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);   //пул для 5 кассиров
        for (int i = 1; i <=5 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threadPool.execute(thread);
        }
        threadPool.shutdown();  //перкащение приему новых потоков
        while (Manager.shopOpened()){
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.shopOpened() && i <= count; i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start(); //запуск потока (покупателя)
            }
            Helper.sleep(1000);
        }
        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=== Shop closed ===");
    }
}