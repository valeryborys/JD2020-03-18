package by.it.tolstik.jd01_13;

import java.util.HashMap;

class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NumberFormatException | NullPointerException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    System.out.printf("name: %s \nclass: %s \nline: %d \n"
                            ,e.getClass().getName()
                            ,element.getClassName()
                            ,element.getLineNumber());;
                }
            }

        }
    }
}
