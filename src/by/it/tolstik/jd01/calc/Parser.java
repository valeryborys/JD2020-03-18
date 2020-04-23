package by.it.tolstik.jd01.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        String[] operand = expression.split(Patterns.OPERATION);
        if (expression.length() == 0) {
            throw new CalcException("blank expression");
        }
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")) {
            return Var.saveVar(operand[0], two);
        }
        Var one = Var.createVar(operand[0]);
        if (one == null || two == null) {
            throw new CalcException("Пусто");
        }
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "/":
                    return one.div(two);
                case "*":
                    return one.mul(two);
            }
        }
        throw new CalcException();
    }
}
