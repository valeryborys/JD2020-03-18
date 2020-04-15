package by.it.borys.calc;

import java.util.regex.Matcher;

public class Parser {

    Var calc(String expression) throws CalcExeption {
        String[] operand = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")){
           return Var.saveVar(operand[0], two);
        }
        Var one = Var.createVar(operand[0]);
        if (one == null || two == null) return null;//туду
        java.util.regex.Pattern p1 = java.util.regex.Pattern.compile(Patterns.OPERATION);
        Matcher m1 = p1.matcher(expression);
        if (m1.find()) {
            String operation = m1.group();
            switch (operation) {
                case "+":
                    return one.add(two);

                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
                default:
                    return null;//туду
            }
        }
        return null;
    }
}