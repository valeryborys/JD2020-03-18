package by.it.okatov.jd02_02;

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
        /***
         * График с чартом запускаются отдельно от основной программы!
         */
        System.out.println("Grand opening!");
        Utils.sethMap();


        long lt = System.nanoTime(); //Считаем время выполнения

        for (int i = 0; i < 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            Utils.threads.add(thread);
            thread.start();

        }
        while (!Manager.supermarketOpened()) {
            int count = Utils.getRandom(0, 2);
            for (int i = 0; Manager.supermarketOpened() && i < count; i++) {
                Buyer buyer = new Buyer(++number);

                buyer.start();
                Utils.threads.add(buyer);
            }
            Utils.waitForSeconds(1);//Ждем одну секунду, чтобы превратить цикл в отсчет 2 минут
        }
        /*for (int time = 0; time < 120; time++) {
            letinBuyersInRange(time); //Устанавливаем отрезки времени для запуска людей
            tmp.put(time, Utils.GLOBAL_COUNTER);

            Utils.waitForSeconds(1);//Ждем одну секунду, чтобы превратить цикл в отсчет 2 минут
        }*/

        long dt = System.nanoTime() - lt;
        for (Thread threads : Utils.threads) {
            try {
                threads.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Grand closing!");
        System.out.println("Количество обычных покупателей: " + (number - numberOfElders));
        System.out.println("Количество пенсионеров: " + numberOfElders);
        System.out.println("Время исполнения: " + dt / 1e9 + "секунд");
        writeToFile(); //Пишем в файл измерения: "Секунда -> Количество людей в данную секунду"
    }

    /***
     * Устанавливает макисмальное количество народа на каждом из отрезков времени.
     * Всего отрезков четыре:
     * 1. Время работы time < 30
     * 2. Время работы 30 < time < 60
     * 3. Время работы 60 < time < 90
     * 4. Время работы 90 < time < 120
     * Макисмальное количество народа для 1-го и 3-го отрезка рассчитывается
     * по формуле (Время+10).
     * Максимальное количество народа для 2-го и 4-го отрезка рассчитывается
     * по формуле (25 - (30 - Время))
     * @param time
     */
    private static void letinBuyersInRange(int time) {
        if (time < 30) {
            if (Utils.GLOBAL_COUNTER <= time + 10) { //Максимум находящегося в магазине народа на текущий момент
                addBuyers(time);
            }
        } else if (time < 60) {
            if (Utils.GLOBAL_COUNTER <= 25 + (30 - time)) {
                addBuyers(time);
            }
        } else if (time < 90) {
            if (Utils.GLOBAL_COUNTER <= time - 60 + 10) {
                addBuyers(time);
            }
        } else {
            if (Utils.GLOBAL_COUNTER <= 25 + (30 - time - 60)) {
                addBuyers(time);
            }
        }

    }

    /***
     * Добавляет покупателей в магазин. Количество единовременно заходящих
     * покупателей зависит от текущей секунды работы магазина. Вычисляется
     * по формуле N = 8+(currentSecond/10). Единовременно может зайти от
     * 0 до N покупателей.
     * @param currentSecond текущая секунда работы магазина.
     */
    private static void addBuyers(int currentSecond) {
        int n;
        Buyer buyer;
        n = 8 + (currentSecond / 10); //Максимум добавляемых покупателей
        int count = Utils.getRandom(0, n);
        for (int i = 0; i <= count; i++) {
            if (i % 4 == 0) {
                buyer = new Buyer(++number, true);
                numberOfElders++; //Кол-во пенсионеров
            } else {
                buyer = new Buyer(++number);
            }

            buyer.start();
        }


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

            tmp.forEach((key, value) -> {
                print.print(key + " ");
                print.println(value);
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
