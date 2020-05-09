package by.it.bobrovich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        label:
        while(true){
            line = scanner.nextLine();
            switch (line) {
                case "end":
                    break label;
                case "be": {
                    Locale locale = new Locale("be", "BY");
                    ResMan.setLocale(locale);
                    continue label;
                }
                case "ru": {
                    Locale locale = new Locale("ru", "RU");
                    ResMan.setLocale(locale);
                    continue label;
                }
                case "en": {
                    Locale locale = new Locale("en", "US");
                    ResMan.setLocale(locale);
                    continue label;
                }
            }
            try {
                printer.print(parser.calc(line));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
