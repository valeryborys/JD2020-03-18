package by.it.verbitsky.calc;

class MatrixCreator extends VariableCreator {

    @Override
    public Var createVar(String value) throws CalcException {
        return new Matrix(value);
    }

    @Override
    public Var createVar(Matrix value) throws CalcException {
        return new Matrix(value);
    }

    @Override
    public Var createVar(double[][] value) throws CalcException {
        return new Matrix(value);
    }

}
