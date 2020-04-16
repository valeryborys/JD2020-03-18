package by.it.sinevich.jd01_13;

import org.junit.runners.model.TestTimedOutException;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        //Уточнить почему при переменных типа int задача не проходила проверку.



        Scanner sc = new Scanner(System.in);
        String str;
        double sum=0;
        double num=0;
        while(!(str=sc.next()).equals("END")) {
                try {
                    num = Double.parseDouble(str);
                    sum += num;
                    if(sum<0){
                        throw new ArithmeticException();
                    }
                    System.out.println(num + " " + Math.sqrt(sum));
                } catch (ArithmeticException | NumberFormatException e) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                            String name = e.getClass().getName();
                            String className = stackTraceElement.getClassName();
                            int line = stackTraceElement.getLineNumber();
                            System.out.printf("  " +
                                            "name: %s\n " +
                                            "class: %s\n " +
                                            " line: %d\n",
                                    name, className, line);
                            break;
                        }
                    }
                }
            }
    }
}
