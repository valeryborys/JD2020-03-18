package by.it.borys.calc;

public class CreateMatrix implements CreateVar {
    @Override
    public Var createVar(String operand) {
        return new Matrix(operand);
    }
}
