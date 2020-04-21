package by.it.gutkovsky.jd01_13;

import java.util.HashMap;

class TaskA {
    public static void main(String[] args) {

        /*
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);

            } else Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int line = element.getLineNumber();
                    System.out.printf(
                             " name: %s\n" +
                             "class: %s\n" +
                             " line: %d",
                             name, clname, line);
                    break;
                }
            }
        }

         */
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
//            Class<? extends RuntimeException> aClass = e.getClass();
//            System.out.println("name:" + aClass.getName());
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement element : trace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    System.out.printf(
                            " name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d",
                            e.getClass().getName(), element.getClassName(), element.getLineNumber());
                    break;
                }
            }
        }
    }
}
