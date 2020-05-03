package by.it.gutkovsky.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = new Logger();
        printer.loadFromMemory(parser);
        label:
        for (; ; ) {
            String expression = sc.nextLine();
            logger.logger(expression);

            switch (expression) {
                case "end":
                    break label;
                case "printvar":  // jd01_11 - taskB part2 // also print var from memory
                    printer.printVar();
                    break;
                case "sortvar":  // jd01_11 - taskC part2
                    printer.sortVar();
                    break;
                case "printmemory":
                    System.out.println("Saved vars:");
                    printer.printFromMemory();
                    break;
                default:

                    try {
                        Var var = parser.calc(expression);
                        printer.saveToMemory();
                        printer.print(var);
                        logger.logger(var.toString());
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        logger.logger(e.getMessage());
                    }
                    break;
            }
        }
    }
}
