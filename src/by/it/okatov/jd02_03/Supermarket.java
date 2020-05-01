package by.it.okatov.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Supermarket {
    public static void main(String[] args) {
        System.out.println("Grand opening!");
        int number = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();//Прекращаем прием новых потоков и останавливаем сервисный поточек
        while (Manager.supermarketOpened()) {
            int count = Utils.getRandom(0, 2);
            for (int i = 0; Manager.supermarketOpened() && i <= count; i++) {
                Buyer buyer;
                if (Utils.GLOBAL_COUNTER.get() % 4 == 0) {
                    buyer = new Buyer(i, true);
                } else {
                    buyer = new Buyer(i);
                }

                buyer.start();
            }
            Utils.waitForSeconds(1);

        }
        Utils.waitForSeconds(2);
        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Grand closing!");
    }
}
