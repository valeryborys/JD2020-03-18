package by.it.verbitsky.jd01_08;

import by.it.verbitsky.jd01_07.Var;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar obj) {
        this.value = obj.value;
    }

    Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
