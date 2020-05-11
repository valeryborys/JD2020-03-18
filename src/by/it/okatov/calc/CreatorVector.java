package by.it.okatov.calc;

public class CreatorVector extends VarFactory {
    @Override
    Var createVar(String strVar) {
        return new Vector(strVar);
    }

    /*@Override
    Var createVar(Var var) {
        return new Vector((Vector) var);
    }

    @Override
    Var createVar(Object doubleVar) {
        return new Vector((double[]) doubleVar);
    }*/
}
