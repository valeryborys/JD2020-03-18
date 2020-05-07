package by.it.tolstik.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        private static final long serialVersionUID = -184387148821079886L;

        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        if (expression.length() == 0) {
            throw new CalcException("Expression was not entered");
        }

        expression = openBrackets(expression);

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        try {
            while (operations.size() > 0) {
                int index = getIndexCurrentOperation(operations);
                String operation = operations.remove(index);
                String left = operands.remove(index);
                String right = operands.remove(index);
                Var result = oneOperation(left, operation, right);
                operands.add(index, result.toString());
            }
        } catch (IndexOutOfBoundsException e) {
            throw new CalcException("Missed operand after operation: " + e);
        }
        return Var.createVar(operands.get(0));
    }

    private String openBrackets(String expression) throws CalcException {
        String expresionInBrackets = expression;
        Matcher matcher = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        while (matcher.find()) {
            Var tempResult = calc(matcher.group().replace("(", "").replace(")", ""));
            expresionInBrackets = openBrackets(expression.replace(matcher.group(), tempResult.toString()));
        }
        return expresionInBrackets;
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