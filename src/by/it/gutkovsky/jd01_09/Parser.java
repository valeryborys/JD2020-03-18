package by.it.gutkovsky.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc (String expresion){
        //2+2;
        String[] parts = expresion.split(Patterns.OPERATION, 2);
        Var left = Var.createVar(parts[0]);
        if ( parts.length == 1){
            return  left;
        }
        Var right = Var.createVar(parts[1]);

        Matcher matcherOp = Pattern.compile(Patterns.OPERATION).matcher(expresion);
        if (matcherOp.find()){
            String operation = matcherOp.group();
            switch (operation){
                case "+" : return left.add(right);
                case "-" : return left.sub(right);
                case "*" : return left.mul(right);
                case "/" : return left.div(right);
            }
        }

        return  null;



    }
}
