package by.it.lemesh.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc;

    public static void main(String[] args) throws InterruptedException, CountException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException, CountException {
        List<Double> list = new ArrayList<>();
        int count = 0;
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            try {
                double num = Double.parseDouble(line);
                list.add(num);
            } catch (Exception e) {
                count++;
                if (count > 5) throw new CountException("Более 5 раз неправильно введены данные!");
                Thread.sleep(100);
                for (int j = list.size() - 1; j >= 0; j--) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private static class CountException extends Exception {
        public CountException() {
        }

        public CountException(String message) {
            super("ERROR: " + message);
        }
    }
}
