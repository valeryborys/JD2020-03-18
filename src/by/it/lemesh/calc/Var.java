package by.it.lemesh.calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    public static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String line) throws CalcException {
        line.trim().replace(" ", "");
        if (line.matches(Patterns.SCALAR))
            return new Scalar(line);
        if (line.matches(Patterns.VECTOR))
            return new Vector(line);
        if (line.matches(Patterns.MATRIX))
            return new Matrix(line);
        if (vars.containsKey(line))
            return vars.get(line);
        else throw  new CalcException("Невозможно создать "+ line);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения невозмжна.");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания невозмжна.");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения невозмжна.");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления невозмжна.");
    }
}
