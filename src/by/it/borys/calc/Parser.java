package by.it.borys.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    Var calc(String expression) throws CalcExeption {
        if (expression.length() < 3) throw new CalcExeption("wrong expression");
        expression = expression.replace(" ", "");
        expression = calcInScopes(expression);
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
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

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcExeption {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }
        Var left = Var.createVar(strLeft);
        //if (left == null || right == null) throw new CalcExeption("wrong line");
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
                throw new CalcExeption("Wrong operation");
        }
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

    private String calcInScopes(String expression) throws CalcExeption {
        String expressionSave = expression;
        Matcher matcher = Pattern.compile(Patterns.IN_SCOPES).matcher(expression);
        while (matcher.find()) {
            String inScope = calc(matcher.group().replace("(", "").replace(")", "")).toString();
            expressionSave = calcInScopes(expression.replace(matcher.group(), inScope));
        }
        return expressionSave;
    }
}