package by.it.bobrovich.jd01_09;

public abstract class Var implements Operation {

    static Var createVar(String value){
        if(value.matches(Patterns.SCALAR))
            return new Scalar(value);
        if(value.matches(Patterns.VECTOR))
            return new Vector(value);
        if(value.matches(Patterns.MATRIX))
            return new Matrix(value);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Impossible operation");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Impossible operation");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Impossible operation");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Impossible operation");
        return null;
    }
}
