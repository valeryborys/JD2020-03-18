package by.it.okatov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskC {

    private static final List<Double> lArr = new ArrayList<>();
    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        readData();
        throw new Exception();
    }

    private static void readData() throws Exception {
        int exceptionCounter = 0;
        do {
            try {
                String nextLine = sc.nextLine();
                for (char c : nextLine.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        throw new ArithmeticException();
                    }
                }
                lArr.add(Double.parseDouble(nextLine));
            } catch (ArithmeticException ex) {
                exceptionCounter++;
                Thread.sleep(100);
                printReverse(lArr);
                if (exceptionCounter >= 5) {
                    return;
                }
            }
        } while (true);


    }

    private static void printReverse(List<Double> dArr) {
        String delimiter = "";

        for (int i = lArr.size() - 1; i >= 0; i--) {
            System.out.print(delimiter + lArr.get(i));
            delimiter = " ";
        }
        System.out.println();
    }
}