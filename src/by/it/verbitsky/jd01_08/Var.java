package by.it.verbitsky.jd01_08;

public abstract class Var implements Operation {
    @Override
    public String toString() {
        return " Abstract Var";
    }

    @Override
    public by.it.verbitsky.jd01_07.Var add(by.it.verbitsky.jd01_07.Var other) {
        System.out.printf("Operation imposible %s + %s", this);
        return null;
    }

    @Override
    public by.it.verbitsky.jd01_07.Var sub(by.it.verbitsky.jd01_07.Var other) {
        return null;
    }

    @Override
    public by.it.verbitsky.jd01_07.Var mul(by.it.verbitsky.jd01_07.Var other) {
        return null;
    }

    @Override
    public by.it.verbitsky.jd01_07.Var div(by.it.verbitsky.jd01_07.Var other) {
        return null;
    }
}
