package by.it.gutkovsky.calc;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    // jd01_11 - taskA part2

    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }

    static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replaceAll("\\s", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw  new CalcException("Unknown var: " + strVar);
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new  CalcException("Operation " + this + " + " + other + " is impossible");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new  CalcException("Operation " + this + " - " + other + " is impossible");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new  CalcException("Operation " + this + " * " + other + " is impossible");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new  CalcException("Operation " + this + " / " + other + " is impossible");
    }

    @Override
    public String toString() {
        return "Abstract Var{}";
    }
}
