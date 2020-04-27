package by.it.verbitsky.jd01_15;

import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fm = new FileManager(
                FileManager.getPath(TaskC.class),
                new FileManagerParser());
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            fm.process(expression);
        }
    }

}
