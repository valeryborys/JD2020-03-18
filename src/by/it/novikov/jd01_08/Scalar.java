package by.it.novikov.jd01_08;


import by.it.novikov.jd01_08.Var;

class Scalar extends Var {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }
    Scalar(String str) {
        this.value=Double.parseDouble(str);
    }
    Scalar(Scalar scalar) {
        this.value=scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
