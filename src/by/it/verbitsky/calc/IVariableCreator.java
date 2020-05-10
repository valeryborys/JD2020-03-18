package by.it.verbitsky.calc;

interface IVariableCreator {

    Var createVar(String value) throws CalcException;

    Var createVar(Scalar value) throws CalcException;

    Var createVar(Vector value) throws CalcException;

    Var createVar(Matrix value) throws CalcException;

    Var createVar(double value) throws CalcException;

    Var createVar(double[] value) throws CalcException;

    Var createVar(double[][] value) throws CalcException;

}
