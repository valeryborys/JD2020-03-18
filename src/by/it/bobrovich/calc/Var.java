package by.it.bobrovich.calc;

public abstract class Var implements Operation {

    static Var createVar(String value) throws CalcException{
        if(value.matches(Patterns.SCALAR))
            return new Scalar(value);
        if(value.matches(Patterns.VECTOR))
            return new Vector(value);
        if(value.matches(Patterns.MATRIX))
            return new Matrix(value);
        throw new CalcException("Impossible to create " + value);
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Impossible operation");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Impossible operation");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Impossible operation");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Impossible operation");
    }
}
