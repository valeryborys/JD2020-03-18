package by.it.lemesh.jd01_09;

public abstract class Var implements Operation {

    static Var createVar(String line) {
        line.trim().replace(" ", "");
        if (line.matches(Patterns.SCALAR))
            return new Scalar(line);
        if (line.matches(Patterns.VECTOR))
            return new Vector(line);
        if (line.matches(Patterns.MATRIX))
            return new Matrix(line);
        else return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения невозмжна.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания невозмжна.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения невозмжна.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления невозмжна.");
        return null;
    }
}
