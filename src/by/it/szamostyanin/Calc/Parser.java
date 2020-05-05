package by.it.szamostyanin.Calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    //создаем таблицу приоритетов
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
        //A=-1+2*3/-2   A=-4
        expression = expression.replace(" ", "");  //убираем пробелы
        if (expression.length() == 0) {
            throw new CalcException("ne expression");
        }
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));   //создаем лист из массива строк, полученного в результате сплита по регулярке
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) { //пока матчер что-то находит
            operations.add(matcher.group()); //добавляет что нашел
        }
        // operands     A -1 2 3 -2
        // operation    =  -  +  /
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = resultOperations(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private Var resultOperations(String strLeft, String operation, String strRight) throws CalcException {
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
        throw new CalcException("resOperation is wrong");
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