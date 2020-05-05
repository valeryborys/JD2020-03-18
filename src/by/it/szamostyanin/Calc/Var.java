package by.it.szamostyanin.Calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static final Map<String, Var> map = new HashMap<>();

    static Var createVar(String operand) throws CalcException {
        //operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else {
            Var var = map.get(operand);
            if (var != null)
                return var;
            else
                throw new CalcException("incorrect name var: " + operand);
        }
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна!\n",this,other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s - %s невозможна!\n",this,other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s * %s невозможна!\n",this,other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s / %s невозможна!\n",this,other));
    }

    public static void save(String name, Var var) {
        map.put(name, var);
    }
}