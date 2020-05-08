package by.it.bobrovich.calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String, Var> list = new HashMap<>();

    static Var createVar(String value) throws CalcException {
        value = value.replace(" ", "");
        if (value.matches(Patterns.SCALAR))
            return new Scalar(value);
        if (value.matches(Patterns.VECTOR))
            return new Vector(value);
        if (value.matches(Patterns.MATRIX))
            return new Matrix(value);
        else {
            Var var = list.get(value);
            if(var != null)
                return var;
            else
                throw new CalcException("Impossible to create " + value);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Impossible operation");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Impossible operation");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Impossible operation");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Impossible operation");
    }

    public static void save(String name, Var var) {
        list.put(name, var);
    }
}
