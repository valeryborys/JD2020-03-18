package by.it.bobrovich.jd01_08;

public abstract class Var implements Operation {
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
