package by.it.lemesh.calc;

public class CreateMatrix implements Creation {
    @Override
    public Var create(String pattern) {
        return new Matrix(pattern);
    }
}
