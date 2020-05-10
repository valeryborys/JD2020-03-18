package by.it.borys.calc;

public class CreateScalar implements CreateVar {
    @Override
    public Var createVar(String operand) {
        return new Scalar(operand);
    }
}
