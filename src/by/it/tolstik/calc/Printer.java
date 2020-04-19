package by.it.tolstik.calc;

class Printer {
    void print(Var var) throws CalcException {
        if (var != null) {
            System.out.println(var);
        }
        else throw new CalcException("object = null");
    }
}
