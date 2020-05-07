package by.it.okatov.calc;


import by.it.okatov.calc.globalization.IError;
import by.it.okatov.calc.globalization.ResourceManager;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    static ResourceManager manager = ResourceManager.INSTANCE;

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
                throw new CalcException(manager.getString(IError.msgErrorVariableName) + strVar);
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
                manager.getString(IError.msgErrorExlamation) +
                        String.format(manager.getString(IError.msgErrorOperationAddiction), this, other)
        );
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format(manager.getString(IError.msgErrorOperationSubtraction), this, other)
        );
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format(manager.getString(IError.msgErrorOperationMultiplication), this, other)
        );
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(
                "ERROR! " +
                        String.format(manager.getString(IError.msgErrorOperationDivision), this, other)
        );
    }

    @Override
    public String toString() {
        return "Var{}";
    }
}
