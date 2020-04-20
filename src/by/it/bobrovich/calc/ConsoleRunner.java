package by.it.bobrovich.calc;

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
            try {
                printer.print(parser.calc(line));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
