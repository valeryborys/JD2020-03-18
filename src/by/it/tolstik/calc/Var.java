package by.it.tolstik.calc;

import java.util.*;

abstract class Var implements Operation {

    ResMan inst = ResMan.INSTANCE;

    private static final Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }

    static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replaceAll("\\s", "");
        if (strVar.matches(Patterns.SCALAR))
            return new CreatorScalar().varFactory(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new CreatorVector().varFactory(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new CreatorMatrix().varFactory(strVar);
        else if (vars.containsKey(strVar)) {
            if (vars.get(strVar) != null) {
                return vars.get(strVar);
            }
        }
        throw new CalcException("Unknown var: " + strVar);
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(inst.get(ErrorMessage.part1) + this + " + " + other + inst.get(ErrorMessage.part2));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(inst.get(ErrorMessage.part1) + this + " - " + other + inst.get(ErrorMessage.part2));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(inst.get(ErrorMessage.part1) + this + " * " + other + inst.get(ErrorMessage.part2));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(inst.get(ErrorMessage.part1) + this + " / " + other + inst.get(ErrorMessage.part2));
    }

    @Override
    public String toString() {
        return "Abstract Var{}";
    }
}