package by.it.verbitsky.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
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
                    return Var.createVar(parts[0]);
            }
        }

        Var right = Var.createVar(parts[1]);

        if (expression.contains("=")) {
            Var.memoryAdd(parts[0], right);
            return right;
        }
        Var left = Var.createVar(parts[0]);
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

        throw new CalcException("Unknown operation");
    }

}

//мой старый вариант
    /*
    Var calc(String expression, CalcMemory buffer) {


        String[] parts = expression.split(Patterns.OPERATION, 2);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (parts.length > 1) {
            if (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "+":
                        return Var.createVar(parts[0]).add(Var.createVar(parts[1]));
                    case "-":
                        return Var.createVar(parts[0]).sub(Var.createVar(parts[1]));
                    case "*":
                        return Var.createVar(parts[0]).mul(Var.createVar(parts[1]));
                    case "/":
                        return Var.createVar(parts[0]).div(Var.createVar(parts[1]));
                    case "=": {
                        buffer.memoryAdd(parts[0], Var.createVar(parts[1]));
                        return null;
                    }
                }
            }
        } else {
            if (parts.length == 1) {
                switch (parts[0]) {
                    case Patterns.COMMAND_PRINTVAR: {
                        buffer.printvar();
                        return null;
                    }

                    case Patterns.COMMAND_SORTVAR: {
                        buffer.sortvar();
                        return null;
                    }
                }
            }
        }

        return null;
    }
}*/
