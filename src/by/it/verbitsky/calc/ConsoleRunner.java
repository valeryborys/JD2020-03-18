package by.it.verbitsky.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        System.out.println("--------------------------------------------------------");
        System.out.println("Use <var name> = <value> to put value in calc memory");
        System.out.println("Use <var name> to get value from calc memory\n");
        System.out.println("Available commands:\nprintvar - show calc memory\nsortvar - show sorted list of calc memory");
        System.out.println("--------------------------------------------------------");

        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }

            try {
                Var res = parser.calc(expression);
                printer.Print(res);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
