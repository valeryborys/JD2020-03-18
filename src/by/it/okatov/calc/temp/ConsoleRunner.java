package by.it.okatov.calc.temp;


import by.it.okatov.calc.temp.logsystem.LogSystem;
import by.it.okatov.jd01_15.TaskB;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(TaskB.getFileName(LogSystem.class, "DebugLog.log")));
        PrintStream logger = new LogSystem(System.out, out);
        System.setOut(logger);
        System.setErr(new LogSystem(System.err, out));

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
