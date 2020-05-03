package by.it.okatov.jd02_03;


import by.it.okatov.jd01_15.TaskB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Supermarket {
    static int number = 0;

    public static void main(String[] args) {
        System.out.println("Grand opening!");
        Utils.sethMapOfGoods();

        List<Cashier> cashiers = new ArrayList<>();//Список для управления открытыми кассирами
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);

            threadPool.execute(cashier);
        }
        threadPool.shutdown();//Прекращаем прием новых потоков и останавливаем сервисный поточек

        long lt = System.nanoTime(); //Считаем время выполнения
        for (int i = 0; Manager.supermarketOpened(); i++) {
            Manager.manageCashBoxes(cashiers);

            addBuyers(i);
        }


        cashiers.get(0).setActive();//Активируем первого кассира
        Utils.waitForSeconds(2);


        try {
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cashiers.forEach(cashier -> {
            Utils.common += cashier.getSumOnCashBox();
        });

        System.out.println("//--------------------------------------------------------------------------------\n"
                                   + "   Общая сумма по магазину: " + Utils.common
                                   + "\n//--------------------------------------------------------------------------------");
        System.out.println("Grand closing!");
        long dt = System.nanoTime() - lt;
        System.out.println("Время исполнения: " + dt / 1e9 + "секунд");
        writeToFile();
    }

    private static void addBuyers(int pseudoTime) {
        int count = Manager.getBuyersRange(pseudoTime);
        for (int i = 0; Manager.supermarketOpened() && i < count; i++) {
            Buyer buyer;
            if (number % 4 == 0) {
                buyer = new Buyer(number++, true);
            } else {
                buyer = new Buyer(number++);
            }

            buyer.start();
        }
        Utils.waitForSeconds(1);

    }


    /***
     * Записывает данные измерений в файл. Данные выглядят
     * как набор из "текущая секунда___текущее кол-во людей"
     */
    private static void writeToFile() {
        try (PrintWriter print = new PrintWriter(
                new File(
                        TaskB.getFileName(
                                Supermarket.class, "Chart.txt"
                        )
                )
        )
        ) {

            Utils.forPrinting.forEach((key, value) -> {
                print.print(key + " ");
                print.println(value);
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
