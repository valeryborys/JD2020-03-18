package by.it.akhmelev.calc13;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer = new Printer();
        for (; ; ) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            try {
                Var var = parser.calc(expression);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
