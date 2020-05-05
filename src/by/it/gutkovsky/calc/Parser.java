package by.it.gutkovsky.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }

    };

    Var calc(String expression) throws CalcException {
        //A=-2+3*-4/-2  A=4
        expression = expression.replace(" ", "");
        if (expression.length() == 0) {
            throw new CalcException("Expression was not entered");
        }

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        // operands  A -2 3 -4 -2
        // operations = +  *  /

        while (operations.size() > 0) {
            int index = getIndexCurrentOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }

        Var left = Var.createVar(strLeft);
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }

        throw new CalcException("Unknown operation");

    }

    private int getIndexCurrentOperation(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (priority.get(op) > pr) {
                pr = priority.get(op);
                index = i;
            }
        }
        return index;
    }
}
