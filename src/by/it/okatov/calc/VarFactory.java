package by.it.okatov.calc;

//Почему именно VarFactory? Потому что созвучно с WarFactory
abstract class VarFactory {
    abstract Var createVar(String strVar);

    abstract Var createVar(Var var);

    abstract Var createVar(Object doubleVar);
}
