package by.it.borys.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while(!(line=sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                Var.printvar(Var.getMap());
                continue;
            }
            if (line.equals("sortvar")) {
                Var.printvar(Var.getSortmap());
                continue;
            }

            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
