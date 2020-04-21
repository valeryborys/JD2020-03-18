package by.it.verbitsky.jd01_13;

import java.util.HashMap;

class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            }
            Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    String name = e.getClass().getName();
                    String classname = element.getClassName();
                    int lineNum = element.getLineNumber();
                    System.out.printf("  name: %s\n class: %s \n  line: %d", name, classname, lineNum);
                }
            }
        }
    }
}
