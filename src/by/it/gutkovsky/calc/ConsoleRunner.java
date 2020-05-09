package by.it.gutkovsky.calc;

import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {

    static ResMan res;

    static {
        res = ResMan.INSTANCE;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
//        Logger logger = new Logger();
        Logger logger = Logger.getInstance();
        printer.loadFromMemory(parser);

        System.out.println("Please, choose locale (en)/ Калі ласка, абярыце мову (be) / Пожалуйста, выберите язык (ru)");
        Locale locale;

        label:
        for (; ; ) {
            String expression = sc.nextLine();
            logger.log(expression);

            switch (expression) {
                case "end":
                    break label;
                case "en":
                    locale = new Locale("en", "US");
                    res.setLocale(locale);
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    res.setLocale(locale);
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    res.setLocale(locale);
                    break;
                case "printvar":  // jd01_11 - taskB part2 // also print var from memory
                    printer.printVar();
                    break;
                case "sortvar":  // jd01_11 - taskC part2
                    printer.sortVar();
                    break;
                case "printmemory":
                    System.out.println("\033[33m" + res.get(PrinterMessage.printMemory) + ": \033[30m");
//                    System.out.println("\033[33mSaved vars: \033[30m");
//                    System.out.println("\tSaved vars:");
                    printer.printFromMemory();
                    break;
                case "clearmemory":
                    try {
                        printer.cleanMemory();
                    } catch (CalcException e) {
                        e.printStackTrace();
                    }
                    break;
                default:

                    try {
                        Var var = parser.calc(expression);
                        printer.saveToMemory();
                        printer.print(var);
                        logger.log(var.toString());
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        logger.log(e.getMessage());
                    }
                    break;
            }
        }
    }
}
