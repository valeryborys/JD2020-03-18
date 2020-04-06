package by.it.lemesh.jd01_08;

public abstract class Var implements Operation {
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
