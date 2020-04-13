package by.it.verbitsky.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc (String expression) {
        String[] parts = expression.split(Patterns.OPERATION, 2);
        for (String part : parts) {
            System.out.println(part);
        }
        Var left = Var.createVar(parts[0]);
        if (parts.length == 1) {
            return left;
        }
        Var right = Var.createVar(parts[1]);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+" : return left.add(right);
                case "-" : return left.sub(right);
                case "*" : return left.mul(right);
                case "/" : return left.div(right);
            }
        }
        return null;
    }
}
