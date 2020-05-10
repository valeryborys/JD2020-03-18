package by.it.verbitsky.calc;

class VectorCreator extends VariableCreator {

    @Override
    public Var createVar(String value) throws CalcException {
        return new Vector(value);
    }

    @Override
    public Var createVar(Vector value) throws CalcException {
        return new Vector(value);
    }

    @Override
    public Var createVar(double[] value) throws CalcException {
        return new Vector(value);
    }


}
