package by.it.lemesh.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static ResMan res = ResMan.INSTANCE;
    public static void main(String[] args) {
        Var.loadMap();
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            processLine(line);
        }
    }

    private static void processLine(String line) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        switch (line) {
            case "printvar": {
                printer.printVars();
                break;
            }
            case "sortvar": {
                printer.printSortVars();
                break;
            }
            case "ru": {
                res.setLocale(new Locale(line, "RU"));
                break;
            }
            case "be": {
                res.setLocale(new Locale(line, "BY"));
                break;
            }
            case "en": {
                res.setLocale(new Locale(line, "US"));
                break;
            }
            default: {
                try {
                    Printer.printLog(line);
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    Printer.printLog(e.getMessage());
                }
            }
        }
    }
}

