package by.it.tolstik.calc;

class CreatorVector implements Creator{
    @Override
    public Var varFactory(String s) {
        return new Vector(s);
    }
}