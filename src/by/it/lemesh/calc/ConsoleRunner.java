package by.it.lemesh.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Var.loadMap();
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                printer.printVars();
            } else if (line.equals("sortvar")) {
                printer.printSortVars();
            } else {
                try {
                    printer.printLog(line);
                    Var result = parser.calc(line);
                    printer.print(result);
                    printer.printLog(result.toString());
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    printer.printLog(e.getMessage());
                }
            }
        }
    }
}

