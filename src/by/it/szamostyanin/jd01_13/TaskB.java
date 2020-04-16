package by.it.szamostyanin.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        double sum = 0;
        for (;;){
            String scan = sc.nextLine();
            if (scan.equals("END"))
                break;
            try {
                Double value = Double.valueOf(scan);
                System.out.println(value);
                list.add(value);
                   for (Double i : list) {
                    sum += i;
                }
                if (sum<=0) {
                    throw new ArithmeticException();
                }
                double sqrt = Math.sqrt(sum);
                System.out.printf("%f\n",sqrt);
                sum =0;
            } catch (NumberFormatException | ArithmeticException e) {
                for (StackTraceElement element : e.getStackTrace()) {
                    if (element.getClassName().equals(TaskB.class.getName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int line = element.getLineNumber();
                        System.out.printf("name: %s\nclass: %s\nline: %d\n", name, className, line);
                    }
                }
            }
        }
    }
}