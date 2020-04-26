package by.it.novikov.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true){
            String expr = sc.nextLine();
            if (expr.equals("end")){
                break;
            }
            else if (expr.equals("printvar")){
                Var.printvar();
            }

            try {
                Var var = parser.calc(expr);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}