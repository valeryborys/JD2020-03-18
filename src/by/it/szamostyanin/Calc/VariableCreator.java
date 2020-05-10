package by.it.szamostyanin.Calc;

class VariableCreator implements VarCreator{
    @Override
    public Var createVar(String operand) throws CalcException {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else {
            Var var = Var.getMap().get(operand);
            if (var != null)
                return var;
            else
                throw new CalcException(Var.getRes().getString(ErrorMessages.INCORRECT_NAME) + " " + operand);
        }
    }

    @Override
    public Var createVar(Scalar value) throws CalcException {
        return new ScalarCreator().createVar(value);
    }

    @Override
    public Var createVar(Vector value) throws CalcException {
        return new VectorCreator().createVar(value);
    }

    @Override
    public Var createVar(Matrix value) throws CalcException {
        return new MatrixCreator().createVar(value);
    }

    @Override
    public Var createVar(double value) throws CalcException {
        return new ScalarCreator().createVar(value);
    }

    @Override
    public Var createVar(double[] value) throws CalcException {
        return new VectorCreator().createVar(value);
    }

    @Override
    public Var createVar(double[][] value) throws CalcException {
        return new MatrixCreator().createVar(value);
    }
}
