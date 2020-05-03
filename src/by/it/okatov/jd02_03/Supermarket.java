package by.it.okatov.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Supermarket {
    public static void main(String[] args) {
        System.out.println("Grand opening!");
        int number = 1;

        List<Cashier> cashiers = new ArrayList<>();//Список для управления открытыми кассирами
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();//Прекращаем прием новых потоков и останавливаем сервисный поточек

        //cashiers.forEach(Cashier::deactivate);

        while (Manager.supermarketOpened()) {
            Manager.manageCashBoxes(cashiers);
            int count = Utils.getRandom(0, 2);
            for (int i = 0; Manager.supermarketOpened() && i <= count; i++) {
                Buyer buyer;
                if (number % 4 == 0) {
                    buyer = new Buyer(number++, true);
                } else {
                    buyer = new Buyer(number++);
                }

                buyer.start();
            }
            Utils.waitForSeconds(1);
            cashiers.get(0).setActive();//Активируем первого кассира
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
