package by.it.gutkovsky.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = new Logger();
        printer.loadFromMemory(parser);
        for (; ; ) {
            String expression = sc.nextLine();
            logger.logger(expression);

            if (expression.equals("end")) {
                break;
            } else if (expression.equals("printvar")) { // jd01_11 - taskB part2 // also print var from memory
                printer.printVar();
            } else if (expression.equals("sortvar")) { // jd01_11 - taskC part2
                Printer.sortVar();
            } else {

                try {
                    Var var = parser.calc(expression);
                    printer.saveToMemory();
                    printer.print(var);
                    logger.logger(var.toString());
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    logger.logger(e.getMessage());
                }
            }
        }
    }
}
