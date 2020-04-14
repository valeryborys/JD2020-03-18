package by.it.lemesh.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        String[] line = expression.split(Patterns.OPERATION, 2);
        Var right = Var.createVar(line[1]);
        if (expression.contains("=")) {
            return Var.saveVar(line[0], right);
        }
        Var left = Var.createVar(line[0]);
        if (left == null || right == null)
            return null;
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
                default:
                    return null;
            }
        }
        return null;
    }
}
