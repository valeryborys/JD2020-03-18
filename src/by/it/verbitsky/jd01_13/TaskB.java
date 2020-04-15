package by.it.verbitsky.jd01_13;

import java.util.Locale;
import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) {
            String input = scanner.next();
            if (input.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                sum += number;
                if (sum <= 0) {
                    throw new ArithmeticException();
                }
                double sqrt = Math.sqrt(sum);
                System.out.printf(Locale.ENGLISH, "%3.1f %3.3f\n", number, sqrt);
            } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                for (StackTraceElement element : e.getStackTrace()) {
                    if (element.getClassName().equals(by.it.verbitsky.jd01_13.TaskB.class.getName())) {
                        String name = e.getClass().getName();
                        String classname = element.getClassName();
                        int lineNum = element.getLineNumber();
                        System.out.printf("  name: %s\n class: %s \n  line: %d\n", name, classname, lineNum);
                    }
                }
            }
        }
    }
}