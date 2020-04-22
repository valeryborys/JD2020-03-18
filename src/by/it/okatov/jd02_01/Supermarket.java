package by.it.okatov.jd02_01;

import by.it.okatov.jd01_15.TaskB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Supermarket {
    static int number = 0;
    static Map<Integer, Integer> tmp = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Grand opening!");
        Utils.sethMap();

        int numberOfElders = 0;

        Buyer buyer;
        long lt = System.nanoTime();
        int n = 0;

        for (int time = 0; time < 120; time++) {
            n = 40 - (30 - time);
            int count = Utils.getRandom(0, n);
            for (int i = 0; i <= count; i++) {
                if (time % 4 == 0) {
                    buyer = new Buyer(++number, true);
                    numberOfElders++;
                } else {
                    buyer = new Buyer(++number);
                }

                buyer.start();
                letinBuyersInRange(time, buyer);
            }
            Utils.waitForSeconds(1);//Ждем одну секунду, чтобы превратить цикл в отсчет 2 минут
        }

        long dt = System.nanoTime() - lt;
        System.out.println("Grand closing!");
        System.out.println("Количество обычных покупателей: " + (number - numberOfElders));
        System.out.println("Количество пенсионеров: " + numberOfElders);
        System.out.println("Время исполнения: " + dt / 1e9 + "секунд");
        writeToFile();
    }

    private static void letinBuyersInRange(int time, Buyer buyer) {
        try {
            if (time < 30) {
                if (number >= time + 10) {
                    buyer.join();
                    tmp.put(time, Utils.globalCounter);
                }
            } else if (time < 60) {
                if (number >= 40 + (30 - time)) {
                    buyer.join();
                    tmp.put(time, Utils.globalCounter);
                }
            } else if (time < 90) {
                if (number >= time - 60 + 10) {
                    buyer.join();
                    tmp.put(time, Utils.globalCounter);
                }
            } else {
                if (number >= 40 + (30 - time - 60)) {
                    buyer.join();
                    tmp.put(time, Utils.globalCounter);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
