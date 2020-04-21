package by.it.okatov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        //Переменные для перехвата ошибок-------
        String name;
        String className;
        int line;
        //--------------------------------------

        Scanner sc = new Scanner(System.in);
        String input = "";
        String tmp;
        while (true) {
            tmp = sc.nextLine();
            if (tmp.equals("END")) {
                break;
            } else {
                input += tmp + " ";
            }
        }

        String[] strArr = input.split(" ");
        double[] dArr = new double[strArr.length];
        try {
            for (int i = 0; i < strArr.length; i++) {
                dArr[i] = Double.parseDouble(strArr[i]);
                System.out.println("Number: " + dArr[i] + "  Sqrt: " + sqrtOfSum(dArr));
            }


        } catch (NumberFormatException | ArithmeticException ex) {
            Class<? extends RuntimeException> aClass = ex.getClass();
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().contains("jd01_13.TaskB")) {
                    name = aClass.getName();
                    className = stackTraceElement.getClassName();
                    line = stackTraceElement.getLineNumber();

                    System.out.printf("  name: %s%n class: %s%n  line: %d%n", name, className, line);
                }
            }
        }


    }

    private static String sqrtOfSum(double[] dArr) throws ArithmeticException {
        String str;
        double sum = 0.0;
        for (int i = dArr.length - 1; i >= 0; i--) {
            sum += dArr[i];
        }
        if (sum < 0) {
            throw new ArithmeticException();
        }
        str = String.valueOf(Math.sqrt(sum));
        return str;
    }
}
