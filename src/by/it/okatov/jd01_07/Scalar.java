package by.it.okatov.jd01_07;

public class Scalar extends Var {

    private double value;


    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar other) {
        this.value = other.value;
    }

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
