package by.it.verbitsky.calc;

import java.util.Scanner;

class ConsoleRunner {
    // создать бесконечный цикл, скангер ввода читать в цикле парсить и выводить
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        CalcMemory buffer = new CalcMemory();
        Var res;
        String command;

        while (true) {
            command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }
            res = parser.calc(command, buffer);
            printer.Print(res);
        }
    }
}
