package by.it.borys.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e){
            Class<?> aClass = TaskA.class;
            String name = aClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(name)) {
                    int lineNumber = element.getLineNumber();
                    System.out.printf(" name: %s\nclass: %s\n line: %d", e,name, lineNumber);
                }
            }
        }

    }
}
