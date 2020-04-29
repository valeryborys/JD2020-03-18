package by.it.verbitsky.calc;

import java.util.Scanner;

class ConsoleRunner implements CalcFiles {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ConsoleRunner.class, CalcFiles.LOG_FILENAME));

        //Читаем файл памяти и добавляем содержимое в память калькулятора
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
                logger.writeLog(expression + " = " + res);
                printer.Print(res);
            } catch (CalcException e) {
                logger.writeLog(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printIntro() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Use <var name> = <value> to put value in calc memory");
        System.out.println("Use <var name> to get value from calc memory\n");
        System.out.println("Available commands:\nprintvar - show calc memory\nsortvar - show sorted list of calc memory");
        System.out.println("--------------------------------------------------------");
    }
}
