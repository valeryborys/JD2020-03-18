package by.it.zambrano.jd01_08;

public abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("error, the operation cannot be performed");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("error, the operation cannot be performed");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("error, the operation cannot be performed");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("error, the operation cannot be performed");
        return null;
    }
}