package by.it.gutkovsky.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double squareRoot = 0;
        double sum = 0;

        while (true) {
            String text = sc.nextLine();
            if (text.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(text);
                sum += number;
                if (sum <= 0) throw new ArithmeticException();
                squareRoot = Math.sqrt(sum);
                System.out.println(number + " " + squareRoot);

            } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                StackTraceElement[] trace = e.getStackTrace();
                for (StackTraceElement element : e.getStackTrace()) {
                    if (element.getClassName().equals(TaskB.class.getName())) {
                        System.out.printf(
                                " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d",
                                e.getClass().getName(), element.getClassName(), element.getLineNumber());
                        break;
                    }
                }
            }
        }
    }
}