package by.it.tolstik.calc;

class CreatorMatrix implements Creator {
    @Override
    public Var varFactory(String s) {
        return new Matrix(s);
    }
}