package by.it.okatov.calc;

public class CreatorScalar extends VarFactory {

    @Override
    Var createVar(String strVar) {
        return new Scalar(strVar);
    }

    /*@Override
    Var createVar(Var var) {
        return new Scalar((Scalar) var);
    }

    @Override
    Var createVar(Object doubleVar) {
        return new Scalar((double) doubleVar);
    }*/
}
