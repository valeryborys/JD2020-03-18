package by.it.tolstik.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) {
            String text = scanner.next();
            if (text.equalsIgnoreCase("END")) break;
            try {
                double value = Double.parseDouble(text);
                sum += value;
                if (sum <= 0) throw new ArithmeticException();
                System.out.println("input: " + value + " Sqrt: " + Math.sqrt(sum));
            } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(TaskB.class.getName())) {
                        System.out.printf("name: %s \nclass: %s \nline: %d \n"
                                , e.getClass().getName()
                                , element.getClassName()
                                , element.getLineNumber());
                    }
                }
            }
        }
    }
}
