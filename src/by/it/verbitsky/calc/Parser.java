package by.it.verbitsky.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression, CalcLogger logger) throws CalcException {
        expression = expression.replace(" ", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        //Если был введн 1 операнд
        if (parts.length == 1) {
            switch (parts[0]) {
                case Patterns.COMMAND_PRINTVAR: {
                    Var.printvar();
                    return null;
                }
                case Patterns.COMMAND_SORTVAR: {
                    Var.sortvar();
                    return null;
                }
                case Patterns.COMMAND_CLEAR_MEMORY: {
                    Var.clearMemory();
                    return null;
                }
                default:
                    return Var.createVar(parts[0].trim());
            }
        }

        Var right = Var.createVar(parts[1].trim());

        if (expression.contains("=")) {
            Var.memoryAdd(parts[0].trim(), right);
            return right;
        }
        Var left = Var.createVar(parts[0].trim());
        Matcher matcher = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);

        if (matcher.find()) {
            String operation = matcher.group();
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
        }
        logger.writeLog("Unknown operation");
        throw new CalcException("Unknown operation");
    }
}