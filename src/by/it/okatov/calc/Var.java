package by.it.okatov.calc;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> hMap = new HashMap<>();

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else {
            Var var = hMap.get(strVar);
            return var;
        }
    }

    //Метод, сохраняющий переменные и их значения в карте
    public static void saveVars(String varName, Var var) {
        hMap.put(varName, var);
    }

    public static Map<String, Var> getVars() {
        return hMap;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Error! ");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Error! ");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Error! ");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Error! ");
        return null;
    }

    @Override
    public String toString() {
        return "Var{}";
    }
}
