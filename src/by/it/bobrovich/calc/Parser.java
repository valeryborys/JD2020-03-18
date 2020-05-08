package by.it.bobrovich.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    List<String> operands;
    List<String> operations;

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

    Var calc(String expression) throws CalcException {
        if (expression.length() == 0) {
            throw new CalcException("no expressions");
        }
        if (checkBracket(expression)) {
            expression = parseExpression(expression);
        }

        return Var.createVar(makeCalculation(expression));
    }

    private String makeCalculation(String expression) throws CalcException {
        operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATIONS)));
        operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATIONS).matcher(expression);
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

    private String parseExpression(String expression) throws CalcException {
        if (!checkBracket(expression))
            return makeCalculation(expression);
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder(expression);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                start = i;
                break;
            }
        }
        end = getBracketIndex(sb);
        //System.out.println(start + " " + end);
        String substring = sb.substring(start + 1, end);
        sb.delete(start, end + 1);
        //System.out.println(substring + " " + sb);
        return parseExpression(sb.insert(start, parseExpression(substring)).toString());
    }

    private boolean checkBracket(String expression) {
        char[] chars = expression.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(')
                return true;
        }
        return false;
    }

    private int getBracketIndex(StringBuilder sb){
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '('){
                count++;
            } else if(sb.charAt(i) == ')'){
                count--;
                if(count == 0)
                    return i;
            }

        }
        return 0;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            Var.save(strLeft, right);
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
        throw new CalcException("one operation failed");
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
