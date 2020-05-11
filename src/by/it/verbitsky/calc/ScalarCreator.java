package by.it.verbitsky.calc;

class ScalarCreator extends VariableCreator {

    @Override
    public Var createVar(String value) throws CalcException {
        return new Scalar(value);
    }

    @Override
    public Var createVar(Scalar value) throws CalcException {
        return new Scalar(value);
    }

    @Override
    public Var createVar(double value) throws CalcException {
        return new Scalar(value);
    }
}
