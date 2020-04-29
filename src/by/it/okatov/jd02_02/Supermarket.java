package by.it.okatov.jd02_02;

import by.it.okatov.jd01_15.TaskB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    static int number = 0;

    public static void main(String[] args) {

        System.out.println("Grand opening!");
        Utils.sethMapOfGoods();
        List<Thread> threads = new ArrayList<>();

        List<Buyer> buyersList = new ArrayList<>();
        List<Cashier> cashiers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            Thread thread = new Thread(cashier);
            thread.setName(cashier.toString());
            threads.add(thread);
            thread.start();
        }

        for (int i = 0; Manager.shopOpened(); i++) {
            Manager.manageCashBoxes(cashiers);

            //addBuyers
            addBuyers(i, threads, buyersList);

        }

        cashiers.get(0).setActive();
        Utils.waitForSeconds(2);


        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Grand closing!");
        writeToFile();
    }

    private static void addBuyers(int pseudoTime, List<Thread> threads, List<Buyer> buyersList) {
        int count = Manager.getBuyersRange(pseudoTime);
        for (int i = 0; Manager.shopOpened() && i < count; i++) {
            Buyer buyer;
            if (number % 4 == 0) {
                buyer = new Buyer(++number, true);
            } else {
                buyer = new Buyer(++number);
            }

            buyer.start();
            buyersList.add(buyer);
            threads.add(new Thread(buyer));
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
