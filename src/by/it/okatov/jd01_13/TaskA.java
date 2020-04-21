package by.it.okatov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        String name;
        String className;
        int line;
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NullPointerException | NumberFormatException ex) {
            Class<? extends RuntimeException> aClass = ex.getClass();
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().contains("jd01_13.TaskA")) {
                    name = aClass.getName();
                    className = stackTraceElement.getClassName();
                    line = stackTraceElement.getLineNumber();

                    System.out.printf("  name: %s%n class: %s%n  line: %d%n", name, className, line);
                }
            }
        }

    }
}
