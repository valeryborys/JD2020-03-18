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

        System.out.println("======================================");
        System.out.println("Choose languages and enter to console:");
        System.out.println("ru - RUSSIAN");
        System.out.println("be - BELARUSIAN");
        System.out.println("en - ENGLISH");
        System.out.println("Waiting for your choice...");
        System.out.println("======================================");
        System.out.println("Доступные команды:");
        System.out.println("print - выведет в консоль все используемые переменные;");
        System.out.println("sort - отсортирует и выведет в консоль все переменные;");
        System.out.println("memory - сохранит переменные в памяти;");
        System.out.println("clear - удалит переменные из памяти;");
        System.out.println("end - завершение программы;");

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
