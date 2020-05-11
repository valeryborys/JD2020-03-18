package by.it.borys.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    ChooseCreation var = new ChooseCreation();
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
        if (expression.length() < 3) throw new CalcExeption(ResMan.res.get(Messages.wrongexp));
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
        CreateVar cv = var.chooseFactory(operands.get(0));
        Var var = cv.createVar(operands.get(0));
        return var;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcExeption {
        CreateVar cvr = var.chooseFactory(strRight);
        Var right = cvr.createVar(strRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }
        CreateVar cvl = var.chooseFactory(strLeft);
        Var left = cvl.createVar(strLeft);
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
                throw new CalcExeption(ResMan.res.get(Messages.wrongop));
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