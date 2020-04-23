package by.it.tolstik.jd01.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars= new HashMap<>();
    static Var saveVar(String name, Var var) {
        vars.put(name,var);
        return var;
    }

    static Var createVar(String operand) throws CalcException{
        operand = operand.trim().replaceAll("\\s","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else {
            if (vars.get(operand)!=null) {
                return vars.get(operand);
            }
            else {
                throw new CalcException("Operand don't exist: " + operand);
            }
        }

    }
    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения " + this + " + " + other + " не возможна.");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания " + this + " - " + other + " не возможна.");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * " + other + " не возможна.");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / " + other + " не возможна.");
    }

    @Override
    public String toString() {
        return "You must override toString in child class!";
    }
}
