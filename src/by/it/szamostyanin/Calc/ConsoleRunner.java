package by.it.szamostyanin.Calc;

import java.util.Scanner;

public class ConsoleRunner {
    private static ResMan res;

    public static ResMan getRes() {
        return res;
    }


    public static void main(String[] args) {
        res = ResMan.INSTANCE;
        Scanner scan = new Scanner(System.in);
        //String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        for (; ; ) {
            String expression = scan.nextLine();
            if (expression.equals("end")) {
                break;
            }
            try {
                Var result = parser.calc(expression);
                printer.printer(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

        /*while (!(line=scan.nextLine()).equals("end")){
            Var result=parser.calc(line);
            printer.printer(result);
        }*/
    }
}
