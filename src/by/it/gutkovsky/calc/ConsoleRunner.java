package by.it.gutkovsky.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("printvar")){ // jd01_11 - taskB part2
                Var.printVar();
                break;
            }
            else if (expression.equals("end")) {
                break;
            }

            Var var = parser.calc(expression);
            printer.print(var);
        }
    }
}
