package by.it.zambrano.jd01_09;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Parser {
    Var calc (String expression){
        String[] operand = expression.split(Patterns.OPERATION, 2);
        Var first = Var.createVar(operand[0]);
        Var second= Var.createVar(operand[1]);
        if (first==null || second==null) {
            return null;
        }
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find())  {
            String operation = m.group();
            switch (operation){
                case "+": return first.add(second);
                case "-": return first.sub(second);
                case "*": return first.mul(second);
                case "/": return first.div(second);
                default: return null;
            }
        }
        return null;
    }
}

