package by.it.lemesh.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    static ResMan res = ResMan.INSTANCE;
    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("-", 1);
            this.put("+", 1);
            this.put("/", 2);
            this.put("*", 2);
        }
    };

    Var calc(String expression) throws CalcException {
        String expr = getExpression(expression);
        String result = calcExpression(expr);
        Printer.printLog(result);
        return Var.createVar(result);
    }

    private String getExpression(String expression) throws CalcException {
        Matcher m = Pattern.compile("[(]([^()]+)[)]").matcher(expression);
        if (m.find()) {
            String subExpression = m.group().replace("(", "").replace(")", "");
            String result = calcExpression(subExpression);
            expression = m.replaceFirst(result);
            expression = getExpression(expression);
        }
        return expression;
    }

    private String calcExpression(String subExpression) throws CalcException {
        List<String> operands = new ArrayList<>(Arrays.asList(subExpression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(subExpression);
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
        return operands.get(0);
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
        throw new CalcException(res.get(Messages.ERROR_OPERATION));
    }

    private int getIndexCurrentOperation(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (priority.get(op) > pr) {
                index = i;
                pr = priority.get(op);
            }
        }
        return index;
    }
}
