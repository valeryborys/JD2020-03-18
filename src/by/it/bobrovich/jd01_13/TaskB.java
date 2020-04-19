package by.it.bobrovich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        Double sum = 0.;
        while (!(str = sc.next()).equals("END")) {
            try {
                Double number = Double.valueOf(str);
                list.add(number);
                for (Double aDouble : list) {
                    sum += aDouble;
                }
                System.out.print(number + " ");
                if(sum<0)
                    throw new ArithmeticException();
                else
                    System.out.println(Math.sqrt(sum));
                sum = 0.;
            } catch (Exception e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if(TaskB.class.getName().equals(stackTraceElement.getClassName())){
                        System.out.println(stackTraceElement);
                        String name = e.getClass().getName();
                        String className = stackTraceElement.getClassName();
                        int line = stackTraceElement.getLineNumber();
                        System.out.printf(
                                " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                name, className, line);
                        break;
                    }
                }
            }
        }
    }
}
