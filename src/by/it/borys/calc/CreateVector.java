package by.it.borys.calc;

public class CreateVector implements CreateVar {
    @Override
    public Var createVar(String operand) {
        return new Vector(operand);
    }
}
