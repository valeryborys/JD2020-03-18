package by.it.lemesh.calc;

public class CreateVector implements Creation {

    @Override
    public Var create(String pattern) {
        return new Vector(pattern);
    }
}
