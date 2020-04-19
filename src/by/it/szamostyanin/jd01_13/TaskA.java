package by.it.szamostyanin.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        /*} catch (NumberFormatException e) {                       //обработка 1 ошибки
            System.out.println("Find error in " + e);*/
        } /*catch (NullPointerException | NumberFormatException e) {  //обработки нескольких ошибок
            Class<? extends RuntimeException> aClass = e.getClass();
            System.out.println("name: " + aClass.getName());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    System.out.println("class: " + element.getClassName());
                    System.out.println("line: " + element.getLineNumber());
                }
            }
        }*/ catch (NullPointerException | NumberFormatException e) {  //обработки нескольких ошибок
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    Integer line = element.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d\n", name, className, line);
                }
            }
        }
    }
}