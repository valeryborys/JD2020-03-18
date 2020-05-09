package by.it.lemesh.calc;

public class CreateScalar implements Creation {

    @Override
    public Var create(String pattern) {
        return new Scalar(pattern);
    }
}
