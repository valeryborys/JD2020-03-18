package by.it.bobrovich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while(true){
            line = scanner.nextLine();
            printer.print(parser.calc(line));
            if(line.equals("end"))
                break;
        }
    }
}
