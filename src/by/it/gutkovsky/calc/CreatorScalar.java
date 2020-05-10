package by.it.gutkovsky.calc;

class CreatorScalar implements Creator {
    @Override
    public Var varFactory(String s) {
        return new Scalar(s);
    }
}
