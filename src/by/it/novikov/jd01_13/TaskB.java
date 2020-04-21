package by.it.novikov.jd01_13;

import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scannedText;
        double sum = 0;
        while (!(scannedText = sc.nextLine()).equals("END")) {
            try {
                double num = Double.parseDouble(scannedText);
                System.out.println(num);
                sum += num;
            } catch (NumberFormatException e) {
                System.out.println("Невозможно перевести в вещественное число:(");
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String cl = element.getClassName();
                        int line = element.getLineNumber();
                        System.out.printf(" name: %s\n" + "class: %s\n" + " line: %d", name, cl, line);
                    }
                }
            }
            try {
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException("Невозможно извлечь корень");
                } else
                    System.out.println(sqrt);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String cl = element.getClassName();
                        int line = element.getLineNumber();
                        System.out.printf(" name: %s\n" + "class: %s\n" + " line: %d", name, cl, line);
                    }
                }
            }


        }

    }
}