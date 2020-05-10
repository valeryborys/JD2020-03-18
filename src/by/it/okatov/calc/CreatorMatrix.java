package by.it.okatov.calc;

public class CreatorMatrix extends VarFactory {
    @Override
    Var createVar(String strVar) {
        return new Matrix(strVar);
    }

    @Override
    Var createVar(Var var) {
        return new Matrix((Matrix) var);
    }

    @Override
    Var createVar(Object doubleVar) {
        return new Matrix((double[][]) doubleVar);
    }
}
