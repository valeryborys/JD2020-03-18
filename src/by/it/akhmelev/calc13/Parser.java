package by.it.akhmelev.calc13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        expression=expression.replace(" ","");
        if (expression.length()==0){
            throw new CalcException("no expression");
        }
        String[] parts = expression.split(Patterns.OPERATION,2);
        if (parts.length==1)
            return Var.createVar(expression);
        Var right= Var.createVar(parts[1]);
        if (expression.contains("=")){
            Var.save(parts[0],right);
            return right;
        }
        Var left= Var.createVar(parts[0]);
        Matcher matcherOp = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        if (matcherOp.find()){
            String operation=matcherOp.group();
            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }


        return null;
    }

}
