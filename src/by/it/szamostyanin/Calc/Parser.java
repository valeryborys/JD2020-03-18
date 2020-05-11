package by.it.szamostyanin.Calc;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static ResMan res = ConsoleRunner.getRes(); //Rm.Instance;
    private static VariableCreator variableCreator = new VariableCreator();

    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 2);
            this.put("*", 3);
            this.put("/", 4);
        }
    };

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "");

        //проверка на пустое выражение
        if (expression.length() == 0) {
            throw new CalcException("Empty expression");
        }
        switch (expression) {
            case "en": {
                res.setLocale(new Locale(expression, "US"));
                return null;
            }
            case "ru": {
                res.setLocale(new Locale(expression, "RU"));
                return null;
            }
            case "be": {
                res.setLocale(new Locale(expression, "BY"));
                return null;
            }
        }

        expression = getSimpleExpression(expression);
        String resVar = calculateSimpleExpression(expression);

        return new VariableCreator().createVar(resVar);
    }

    private String calculateSimpleExpression(String expression) throws CalcException {
        expression = expression.replace("(", "").replace(")", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return operands.get(0);
    }

    private String getSimpleExpression(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.OPERATION_IN_BRACERS);
        Matcher matcher = pattern.matcher(expression);

        if (!expression.contains("(")) {
            return expression;
        } else {
            matcher.find();
            String buf = calculateSimpleExpression(matcher.group());
            expression = expression.replace(matcher.group(), buf);
            expression = getSimpleExpression(expression);
        }
        return expression;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = new VariableCreator().createVar(strRight.trim());

        if (operation.equals("=")) {
            Var.save(strLeft, right);
            return right;
        }
        Var left = new VariableCreator().createVar(strLeft);
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
        throw new CalcException("Wrong operation");
    }

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int pryor = -1;
        for (int i = 0; i < operations.size(); i++) {
            String getOperate = operations.get(i);
            if (priority.get(getOperate) > pryor) {
                pryor = priority.get(getOperate);
                index = i;
            }
        }
        return index;
    }
}