package by.it.verbitsky.jd01_15;

import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManagerParser parser = new FileManagerParser();
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            parser.parse(expression);
        }
    }

}
