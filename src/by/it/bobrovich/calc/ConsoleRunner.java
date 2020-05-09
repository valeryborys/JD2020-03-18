package by.it.bobrovich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while(true){
            line = scanner.nextLine();
            if(line.equals("end"))
                break;
            else if(line.equals("be")){
                Locale locale = new Locale("be", "BY");
                ResMan.setLocale(locale);
                continue;
            }else if(line.equals("ru")){
                Locale locale = new Locale("ru", "RU");
                ResMan.setLocale(locale);
                continue;
            }else if(line.equals("en")){
                Locale locale = new Locale("en", "US");
                ResMan.setLocale(locale);
                continue;
            }
            try {
                printer.print(parser.calc(line));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
