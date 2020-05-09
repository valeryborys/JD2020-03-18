package by.it.gutkovsky.calc;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    // jd01_11 - taskA part2

    static Var saveVar(String name, Var var) {
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
        else if (vars.containsKey(strVar)) {
            if (vars.get(strVar) != null) {
                return vars.get(strVar);
            }
        }
//        throw new CalcException("Unknown var: " + strVar);
        throw new CalcException(ConsoleRunner.res.get(CalcExceptionMessage.unknownVar) + " " + strVar);
    }


    @Override
    public Var add(Var other) throws CalcException {
//        throw new CalcException("Operation " + this + " + " + other + " is impossible");
        throw new CalcException(ConsoleRunner.res.get(CalcExceptionMessage.operationMessage) + " " + this + " + " + other +
                " " + ConsoleRunner.res.get(CalcExceptionMessage.isImpossible));
    }

    @Override
    public Var sub(Var other) throws CalcException {
//        throw new CalcException("Operation " + this + " - " + other + " is impossible");
        throw new CalcException(ConsoleRunner.res.get(CalcExceptionMessage.operationMessage) + " " + this + " - " + other +
                " " + ConsoleRunner.res.get(CalcExceptionMessage.isImpossible));
    }

    @Override
    public Var mul(Var other) throws CalcException {
//        throw new CalcException("Operation " + this + " * " + other + " is impossible");
        throw new CalcException(ConsoleRunner.res.get(CalcExceptionMessage.operationMessage) + " " + this + " * " + other +
                " " + ConsoleRunner.res.get(CalcExceptionMessage.isImpossible));
    }

    @Override
    public Var div(Var other) throws CalcException {
//        throw new CalcException("Operation " + this + " / " + other + " is impossible");
        throw new CalcException(ConsoleRunner.res.get(CalcExceptionMessage.operationMessage) + " " + this + " / " + other +
                " " + ConsoleRunner.res.get(CalcExceptionMessage.isImpossible));
    }

    @Override
    public String toString() {
//        return "Abstract Var{}";
        return ConsoleRunner.res.get(PrinterMessage.message);
    }
}
