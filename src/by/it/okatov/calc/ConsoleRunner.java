package by.it.okatov.calc;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parse = new Parser();
        Printer print = new Printer();
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")) {
                return;
            }

            Var var = parse.calc(expression);
            print.print(var);
        }
    }
}
