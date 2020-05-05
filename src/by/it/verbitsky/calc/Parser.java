package by.it.verbitsky.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static CalcLogger fLogger;
    private static final Map<String, Integer> priority =
            new HashMap<String, Integer>() {
                {
                    this.put("=", 0);
                    this.put("+", 1);
                    this.put("-", 1);
                    this.put("*", 2);
                    this.put("/", 2);
                }
            };

    public Var calc(String expression, CalcLogger logger) throws CalcException {
        fLogger = logger;
        expression = expression.replace(" ", "");

        //проверка на пустое выражение
        if (expression.length() == 0) {
            fLogger.writeLog("empty expression");
            throw new CalcException("empty expression");
        }
        //проверка на одиночные команды (printvar, sotvar, clearmemory)
        if (checkSingleCommand(expression)) {
            return null;
        }

        expression = getSimpleExpression(expression);
        String resVar = calculateSimpleExpression(expression);

        return Var.createVar(resVar);
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
            int index = getIndexCurrentOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return operands.get(0);
    }

    private String getSimpleExpression(String expression) throws CalcException {
        System.out.println("get simple expr: " + expression);
        Pattern pattern = Pattern.compile(Patterns.OPERATION_IN_BRACERS);
        Matcher matcher = pattern.matcher(expression);

        if (!expression.contains("(")) {
            return expression;
        } else {
            matcher.find();
            String buf = calculateSimpleExpression(matcher.group());
            System.out.println("getsimple: expr before = " + expression);
            System.out.println("getsimple: group = " + matcher.group());
            System.out.println("getsimple: buf = " + buf);
            expression = expression.replace(matcher.group(), buf);
            System.out.println("getsimple: expr after replace = " + expression);
            expression = getSimpleExpression(expression);
        }
        return expression;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight.trim());

        if (operation.equals("=")) {
            Var.memoryAdd(strLeft, right);
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
        fLogger.writeLog("OneOperation failed");
        throw new CalcException("OneOperation failed");
    }

    private int getIndexCurrentOperation(List<String> operations) {
        int index = -1;
        int cur = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priority.get(operation) > cur) {
                cur = priority.get(operation);
                index = i;
            }
        }
        return index;
    }

    private boolean checkSingleCommand(String expression) {
        String[] parts = expression.split(Patterns.OPERATION, 2);
        //Если был введн 1 операнд
        if (parts.length == 1) {
            switch (parts[0]) {
                case Patterns.COMMAND_PRINTVAR: {
                    Var.printvar();
                    return true;
                }
                case Patterns.COMMAND_SORTVAR: {
                    Var.sortvar();
                    return true;
                }
                case Patterns.COMMAND_CLEAR_MEMORY: {
                    Var.clearMemory();
                    return true;
                }
            }
        }
        return false;
    }
}