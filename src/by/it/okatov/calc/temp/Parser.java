package by.it.okatov.calc.temp;

import by.it.okatov.calc.temp.globalization.IError;
import by.it.okatov.calc.temp.globalization.ResourceManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Parser {

    static ResourceManager manager = ResourceManager.INSTANCE;

    private static final Map<String, Integer> operationPriority =
            new HashMap<String, Integer>() {
                {
                    this.put("=", 0);
                    /*this.put("(", 0);
                    this.put(")", 0);*/
                    this.put("+", 1);
                    this.put("-", 1);
                    this.put("*", 2);
                    this.put("/", 2);

                }

            };

    Var calc(String expression) throws CalcException {
        //A=-2+3*-4/-2 A=4
        expression = expression.replace(" ", "");
        if (expression.length() == 0) {
            throw new CalcException(manager.getString(IError.msgErrorNoOperation));
        }

        Pattern pattern = Pattern.compile("[(]([^()]+)[)]");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String brackets = calc(matcher.group(1)).toString();
            StringBuilder sb = new StringBuilder(expression);
            expression = sb.replace(matcher.start(), matcher.end(), brackets).toString();
            expression = expression.replaceAll("\\s+", "");
            matcher = pattern.matcher(expression);

        }

        //X = 1+2*(3+4/2-(1+2))*2+1
        List<String> operandsList = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operationsList = new ArrayList<>();
        matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operationsList.add(matcher.group());
        }

        //operands  A -2  3 -4 -2
        //operations =  +  *  /

        while (operationsList.size() > 0) {
            int index = getCurrentOperationIndex(operationsList);
            String operation = operationsList.remove(index);
            String leftPart = operandsList.remove(index);
            String rightPart = operandsList.remove(index);
            Var result = performCurrentOperation(leftPart, operation, rightPart);
            operandsList.add(index, result.toString());
        }
        return Var.createVar(operandsList.get(0));
    }


    private Var performCurrentOperation(String leftPart, String operation, String rightPart)
            throws CalcException {
        Var r = Var.createVar(rightPart);
        if (operation.equals("=")) {
            Var.saveVars(leftPart, r);
            r.setStrName(leftPart);
            return r;
        }
        Var l = Var.createVar(leftPart);
        switch (operation) {
            case "+":
                return l.add(r);
            case "-":
                return l.sub(r);
            case "*":
                return l.mul(r);
            case "/":
                return l.div(r);
        }
        throw new CalcException(manager.getString(IError.msgErrorOperationFailed));
    }

    private int getCurrentOperationIndex(List<String> operationsList) {
        int index = -1;
        int priority = -1;

        for (int i = 0; i < operationsList.size(); i++) {
            String op = operationsList.get(i);
            if ((operationPriority.get(op)) > priority) {
                priority = operationPriority.get(op);
                index = i;
            }
        }
        return index;

    }

    static void sortVar() {
        String str;
        Stream<Map.Entry<String, Var>> sorted =
                Var.getVars().entrySet().stream()
                        .sorted(Map.Entry.comparingByKey());
        Printer print = new Printer();

        Map<String, Var> tmp =
                new HashMap<>(sorted.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        for (Map.Entry<String, Var> entry : tmp.entrySet()) {
            str = String.format("%s=%s", entry.getKey(), entry.getValue()).toUpperCase();
            print.print(str);
        }
    }

    static void printVar() {
        String str;
        Printer printer = new Printer();
        for (Map.Entry<String, Var> entry : Var.getVars().entrySet()) {
            str = String.format("%s=%s", entry.getKey(), entry.getValue()).toUpperCase();
            printer.print(str);
        }

    }
}
