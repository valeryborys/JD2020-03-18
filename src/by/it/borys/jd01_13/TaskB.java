package by.it.borys.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        String line;
        double sum=0;
        Scanner sc = new Scanner(System.in);
        while (!(line = sc.next()).equals("END")) {
            try {
                double i = Double.parseDouble(line);
                if (i>=0) {
                    System.out.println(i);
                    sum += i;
                    System.out.println(Math.sqrt(sum));
                    } else throw new ArithmeticException();
            } catch (NullPointerException | NumberFormatException | ArithmeticException e) {
                Class<?> bClass = TaskB.class;
                String name = bClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(name)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d", e, name, lineNumber);
                    }
                }
            }
        }
     }
}

