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

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value + -otherValue;
            return new Scalar(result);
        }
        return other.mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value * otherValue;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            if (otherValue == 0) {
                super.div(other);
            }
            double result = this.value / otherValue;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
