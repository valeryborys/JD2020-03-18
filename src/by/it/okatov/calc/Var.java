package by.it.okatov.calc;


import by.it.okatov.calc.temp.Patterns;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements IOperation {

    private static final Map<String, Var> hMap = new HashMap<>();
    private String strName;

    public String getStrName() {
        return this.strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else {
            Var var = hMap.get(strVar);
            if (var != null) {
                return var;
            } else {
                throw new CalcException("incorrect name of variable: " + strVar);
            }
        }
    }

    //Метод, сохраняющий переменные и их значения в карте
    public static void saveVars(String varName, Var var) {
        var.setStrName(varName);
        hMap.put(varName, var);
    }

    public static Map<String, Var> getVars() {
        return hMap;
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, other)
        );
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, matrix)
        );
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, scalar)
        );
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, vector)
        );
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, other)
        );
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, matrix)
        );
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, scalar)
        );
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, vector)
        );
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, other)
        );
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, matrix)
        );
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, scalar)
        );
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, vector)
        );
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, other)
        );
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, matrix)
        );
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, scalar)
        );
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format("Operation %s + %s is impossible\n", this, vector)
        );
    }

    @Override
    public String toString() {
        return "Var{}";
    }
}
