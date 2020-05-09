package by.it.tolstik.calc;

import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Util util = new Util();
        Logger logger = new Logger();
        ResMan inst = ResMan.INSTANCE;
        util.loadFromMemory(parser);

        System.out.println("======================================");
        System.out.println("Choose languages and enter to console:");
        System.out.println("ru - RUSSIAN");
        System.out.println("be - BELARUSIAN");
        System.out.println("en - ENGLISH");
        System.out.println("======================================");
        System.out.println("help - available commands");
        System.out.println("======================================");
        System.out.println("Waiting for your choice...");
        System.out.println("======================================");

        while (!flag) {
            String expression = sc.nextLine();
            logger.logger(expression);
            switch (expression) {
                case "ru":
                    inst.locale = new Locale("ru", "RU");
                    inst.setLocale(inst.locale);
                    break;
                case "be":
                    inst.locale = new Locale("be", "BY");
                    inst.setLocale(inst.locale);
                    break;
                case "en":
                    inst.locale = new Locale("en", "US");
                    inst.setLocale(inst.locale);
                    break;
                case "help":
                    System.out.println(inst.get(Message.help_start));
                    System.out.println(inst.get(Message.help_print));
                    System.out.println(inst.get(Message.help_sort));
                    System.out.println(inst.get(Message.help_memory));
                    System.out.println(inst.get(Message.help_clear));
                    System.out.println(inst.get(Message.help_end));
                    break;
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
                    System.out.println(inst.get(Message.savedVar));
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
