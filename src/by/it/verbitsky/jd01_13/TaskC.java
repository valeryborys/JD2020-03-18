package by.it.verbitsky.jd01_13;

import java.util.*;

class TaskC {
    private static Scanner scanner;
    private static double errorCount;
    private static LinkedList<Double> list = new LinkedList<>();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    static void readData() {
        if (errorCount == 5) {
            //Если ошибок 5 - кидаем RE в jvm
            throw new RuntimeException();
        }
        String str = scanner.nextLine();
        try {
            list.add(Double.parseDouble(str));
        } catch (Exception ex) {
            //ex.printStackTrace(); //- по заданию непонятно, надо ли что-то выводить на экран
            //поэтому подавляем
            errorCount++;
            try {
                Thread.sleep(100);
                StringBuilder sb = new StringBuilder();
                double value;
                //читаем сканер
                for (int i = 0; i < list.size(); i++) {
                    value = list.pollLast();
                    sb.append(value).append(" ");
                    list.push(value);
                }
                System.out.println(sb.toString());
            } catch (Exception e) {
                //e.printStackTrace(); //- по заданию непонятно, надо ли что-то выводить на экран
                //поэтому подавляем
            }
        }
    }
}
