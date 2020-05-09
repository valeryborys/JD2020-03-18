package by.it.tolstik.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Util util = new Util();
        Logger logger = new Logger();
        util.loadFromMemory(parser);

        while (!flag) {
            String expression = sc.nextLine();
            logger.logger(expression);
            switch (expression) {
                case "end":
                    flag = true;
                    break;
                case "print":
                    util.printVar();
                    break;
                case "sort":
                    util.sortVar();
                    break;
                case "memory":
                    System.out.println("Saved vars:");
                    util.printFromMemory();
                    break;
                case "clear":
                    try {
                        util.cleanMemory();
                    } catch (CalcException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        Var var = parser.calc(expression);
                        util.saveToMemory();
                        util.print(var);
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
