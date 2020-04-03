package by.it.okatov.jd01_08;

class Scalar extends Var {

    private double value;


    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar other) {
        this.value = other.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
