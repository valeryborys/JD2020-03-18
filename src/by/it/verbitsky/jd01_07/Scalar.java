package by.it.verbitsky.jd01_07;

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
