package by.it.lemesh.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double sumSqr;
        String line;
        double number;
        while (!(line = sc.nextLine()).equals("END")) {
            try {
                number = Double.parseDouble(line);
                sum += number;
                if (sum < 0) throw new ArithmeticException();
                sumSqr = Math.sqrt(sum);
                System.out.print(number + "\n" + sumSqr + "\n");
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int num = element.getLineNumber();
                        System.out.printf("name: %s\nclass: %s\nline: %d", name, className, num);
                    }
                }
            }
        }
    }
}