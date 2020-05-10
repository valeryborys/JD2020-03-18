package by.it.novikov.calc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
return var;
    }
    static void printvar (){
        List<String> keys = new ArrayList<>(vars.keySet());
        for (String key : keys) {
            System.out.println(key + "=" + vars.get(key));
        }
    }


    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " + " + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция " + this + " - " + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция " + this + " * " + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция " + this + " / " + other + " невозможна");
    }

    static Var create(String strVar) throws CalcException {
        strVar = strVar.trim().replace(" ", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix((strVar));
        } else if (vars.containsKey(strVar)) {
            return vars.get(strVar);

        }
        throw new CalcException("Невозможно создать " + strVar);
    }
}



