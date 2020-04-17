package by.it.akhmelev.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement element : trace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    System.out.printf("  name: %s\n class: %s\n  line: %d",
                            name,className,lineNumber);
                    break;
                }
            }
        }
    }
}
