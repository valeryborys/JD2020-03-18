package by.it.okatov.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Parser {

    Var calc(String expression) {
        expression = expression.replaceAll(" ", "");

        //Если пользователь ввел printVar, то вызываем одноименный метод для печати выражения
        if (expression.equals("printVar") || expression.equals("printvar")) {
            printVar();
        } else if (expression.equals("sortVar") || expression.equals("sortvar")) {//Если пользователь ввел sortVar, то вызываем одноименный метод для сортировки выражения
            sortVar();
        }

        String[] parts = expression.split(Patterns.OPERATION, 2);//Делим входную строку на 2 элемента
        Var left = Var.createVar(parts[0]);//Получаем левую часть выражения как первый элемент массива строк
        if (parts.length == 1) {//Если в массиве только один элемент, то он остается левой частью выражения
            return left;
        }

        Var right = Var.createVar(parts[1]); //Правая часть выражения
        if (expression.contains("=")) {
            Var.saveVars(parts[0], right);//Сохраняем в карту имя переменной и присвоенное ей значение
            return right;
        }


        //Паттерн регулярки: -+*/=
        Matcher matcherOp = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcherOp.find()) {
            String operation = matcherOp.group();
            //В зависимости от символа операции вызываем нужный метож
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


        return null;
    }

    private void sortVar() {
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

    private void printVar() {
        String str = "";
        Printer printer = new Printer();
        for (Map.Entry<String, Var> entry : Var.getVars().entrySet()) {
            str = String.format("%s=%s", entry.getKey(), entry.getValue()).toUpperCase();
            printer.print(str);
        }

    }
}
