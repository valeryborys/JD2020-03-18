package by.it.bobrovich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException{
        String[] operand = expression.split(Patterns.OPERATIONS);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if(one == null || two == null)
            return null;
        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
