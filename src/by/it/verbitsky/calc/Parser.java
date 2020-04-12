package by.it.verbitsky.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression, CalcMemory buffer) {


        String[] parts = expression.split(Patterns.OPERATION, 2);
/*
        for (String part : parts) {
            System.out.println(part);
        }
*/
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

        //Var left = Var.createVar(parts[0]);
        /* не понял к чему эта строка
        if (parts.length == 1) {
            return left;
        }*/
        //Var right = Var.createVar(parts[1]);
        return null;
    }
}
