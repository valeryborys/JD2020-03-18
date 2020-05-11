package by.it.szamostyanin.Calc;

import java.util.Scanner;

public class ConsoleRunner {
    private static ResMan res;

    public static ResMan getRes() {
        return res;
    }

    public static void main(String[] args) {
        CalcLogger logger = CalcLogger.INSTANCE;
        res = ResMan.INSTANCE;
        Scanner scan = new Scanner(System.in);
        System.out.println(res.getString(ErrorMessages.MESSAGE_LANGUAGE));

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
                logger.log(expression+" "+result);
            } catch (CalcException e) {
                logger.log(e.getClass()+": "+e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
