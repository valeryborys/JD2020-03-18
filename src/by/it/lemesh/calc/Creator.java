package by.it.lemesh.calc;

public class Creator {

    public Var create(String pattern) throws CalcException {
        pattern = pattern.trim().replace(" ", "");
        if (pattern.matches(Patterns.SCALAR))
            return new CreateScalar().create(pattern);
        if (pattern.matches(Patterns.VECTOR))
            return new CreateVector().create(pattern);
        if (pattern.matches(Patterns.MATRIX))
            return new CreateMatrix().create(pattern);
        if (Var.vars.containsKey(pattern))
            return Var.vars.get(pattern);
        else throw new CalcException(ResMan.INSTANCE.get(Messages.ERROR_CREATE) +" "+ pattern);
    }
}
