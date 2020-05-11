package by.it.verbitsky.calc;

class VariableCreator implements IVariableCreator {
    private ResourceManager rm = ResourceManager.INSTANCE;

    @Override
    public Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new ScalarCreator().createVar(strVar);
        }
        if (strVar.matches(Patterns.VECTOR)) {
            return new VectorCreator().createVar(strVar);
        }
        if (strVar.matches(Patterns.MATRIX)) {
            return new MatrixCreator().createVar(strVar);
        } else {
            if (Var.getCalcMemory().containsKey(strVar)) {
                return Var.getCalcMemory().get(strVar);
            }
            // Var var = calcMemory.get(strVar);
            // if (var != null) {
            //    return var;}
            else {
                throw new CalcException(String.format(rm.getMessage(CalcMessages.SYSTEM_ERROR_UNKNOWN_VAR), strVar));
            }
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
