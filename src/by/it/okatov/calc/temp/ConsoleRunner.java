package by.it.okatov.calc.temp;


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
            //Если пользователь ввел printVar, то вызываем одноименный метод для печати выражения
            if (expression.equals("printVar") || expression.equals("printvar")) {
                Parser.printVar();
                continue;
            } else if (expression.equals("sortVar") || expression.equals("sortvar")) {//Если пользователь ввел sortVar, то вызываем одноименный метод для сортировки выражения
                Parser.sortVar();
                continue;
            }

            try {
                Var var = parse.calc(expression);
                print.print(var);
            } catch (CalcException calcException) {
                System.out.println(calcException.getMessage());
            }

        }
    }
}
