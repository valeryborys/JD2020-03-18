package by.it.verbitsky.calc;

import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner implements CalcFiles {
    private static ResourceManager rm;
    private static SingleLogger singleLogger;
    static {
        rm = ResourceManager.INSTANCE;
        singleLogger = SingleLogger.INSTANCE;
    }


    public static void main(String[] args) {
        checkArgs(args);
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ConsoleRunner.class, CalcFiles.LOG_FILENAME));


        //Читаем файл памяти и добавляем содержимое в память калькулятора
        readCalcMemory(logger);
        printIntro();

        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                //Пробуем записать память калькулятора в файл
                CalcMemoryManager.writeMemoryToFile(CalcMemoryManager.getFullPath(
                        ConsoleRunner.class,
                        CalcFiles.MEMORY_FILENAME)
                );
                break;
            }

            try {
                Var res = parser.calc(expression, logger);

                writeExpressionToLog(logger, expression, res);

                printer.Print(res);
            } catch (CalcException e) {
                logger.writeLog(e.getMessage());
                singleLogger.writeLog(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }

    private static void writeExpressionToLog(CalcLogger logger, String expression, Var res) {
        if (res != null) {
            logger.writeLog(expression + " = " + res);
            singleLogger.writeLog(expression.concat(" = ").concat(res.toString()));
        } else {
            logger.writeLog(expression);
            singleLogger.writeLog(expression);
        }
    }

    private static void readCalcMemory(CalcLogger logger) {
        try {
            CalcMemoryManager.readMemoryFromFile(
                    CalcMemoryManager.getFullPath(
                            ConsoleRunner.class,
                            CalcFiles.MEMORY_FILENAME),
                    logger);
        } catch (CalcException e) {
            System.out.println(e.getMessage());
            logger.writeLog(e.getMessage());
        }
    }

    public static void printIntro() {
        System.out.println("--------------------------------------------------------");
        System.out.println(rm.getMessage(CalcMessages.SYSTEM_MESSAGE_HINT_HEADER));
        System.out.print(rm.getMessage(CalcMessages.SYSTEM_MESSAGE_HINT_PRINTVAR));
        System.out.print(rm.getMessage(CalcMessages.SYSTEM_MESSAGE_HINT_SORTVAR));
        System.out.println(rm.getMessage(CalcMessages.SYSTEM_MESSAGE_HINT_CLEAR));
        System.out.println();
        System.out.println(rm.getMessage(CalcMessages.SYSTEM_MESSAGE_HINT_MEMORY_ADD));
        System.out.println(rm.getMessage(CalcMessages.SYSTEM_MESSAGE_HINT_MEMORY_GET));
        System.out.println("--------------------------------------------------------");
    }

    public static ResourceManager getRm() {
        return rm;
    }

    private static void checkArgs(String[] args) {
        if (args.length > 0) {
            try {
                rm.setLocaleForBundle(new Locale(args[0], args[1]));
            } catch (Exception e) {
                singleLogger.writeLog(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
