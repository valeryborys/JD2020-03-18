package by.it.szamostyanin.Calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static ResMan res = ConsoleRunner.getRes();

    private static Map<String, Var> map = new HashMap<>();

    public static Map<String, Var> getMap() {
        return map;
    }

    public static ResMan getRes() {
        return res;
    }
/*
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
                throw new CalcException(res.getString(ErrorMessages.INCORRECT_NAME) + " " + operand);
        }
    }
*/

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(res.getString(ErrorMessages.ERROR_IMPOSSIBLE), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(res.getString(ErrorMessages.ERROR_IMPOSSIBLE), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(res.getString(ErrorMessages.ERROR_IMPOSSIBLE), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(res.getString(ErrorMessages.ERROR_IMPOSSIBLE), this, other));
    }

    public static void save(String name, Var var) {
        map.put(name, var);
    }
}