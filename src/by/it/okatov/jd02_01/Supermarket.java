package by.it.okatov.jd02_01;

import by.it.okatov.jd01_15.TaskB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Supermarket {
    static int number = 0;
    static int numberOfElders = 0;

    static Map<Integer, Integer> tmp = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Grand opening!");
        Utils.sethMap();


        long lt = System.nanoTime();
        int n = 0;

        for (int time = 0; time < 120; time++) {
            letinBuyersInRange(time);
            tmp.put(time, Utils.GLOBAL_COUNTER);
            Utils.waitForSeconds(1);//Ждем одну секунду, чтобы превратить цикл в отсчет 2 минут
        }

        long dt = System.nanoTime() - lt;
        for (Buyer customer : Utils.lBuyer) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Grand closing!");
        System.out.println("Количество обычных покупателей: " + (number - numberOfElders));
        System.out.println("Количество пенсионеров: " + numberOfElders);
        System.out.println("Время исполнения: " + dt / 1e9 + "секунд");
        writeToFile();
    }

    private static void letinBuyersInRange(int time) {
        if (time < 30) {
            if (Utils.GLOBAL_COUNTER <= time + 10) {
                addBuyers(time);
            }
        } else if (time < 60) {
            if (Utils.GLOBAL_COUNTER <= 40 + (30 - time)) {
                addBuyers(time);
            }
        } else if (time < 90) {
            if (Utils.GLOBAL_COUNTER <= time - 60 + 10) {
                addBuyers(time);
            }
        } else {
            if (Utils.GLOBAL_COUNTER <= 40 + (30 - time - 60)) {
                addBuyers(time);
            }
        }

    }

    private static void addBuyers(int time) {
        int n;
        Buyer buyer;
        n = 10 + time / 9;
        int count = Utils.getRandom(0, n);
        for (int i = 0; i <= count; i++) {
            if (time % 4 == 0) {
                buyer = new Buyer(++number, true);
                numberOfElders++;
            } else {
                buyer = new Buyer(++number);
            }

            buyer.start();
        }


    }

    private static void writeToFile() {
        try (PrintWriter print = new PrintWriter(
                new File(
                        TaskB.getFileName(
                                Supermarket.class, "Chart.txt"
                        )
                )
        )
        ) {

            tmp.forEach((key, value) -> {
                print.print(key + " ");
                print.println(value);
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
