package by.it.okatov.calc;

public class Scalar extends Var {
    private final double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar other) {
        this.value = other.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        return matrix.add(this);
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        double result = this.value + scalar.value;
        return new Scalar(result);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        return vector.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        return matrix.mul(this);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        double result = this.value * scalar.value;
        return new Scalar(result);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        return vector.mul(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }


    @Override
    public Var sub(Matrix matrix) throws CalcException {
        return matrix.mul(new Scalar(-1));
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        double result = this.value + -scalar.value;
        return new Scalar(result);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        return vector.mul(new Scalar(-1));
    }

    @Override
    public Var div(Var other) throws CalcException {
        return this.div((Scalar) other);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        return super.div(matrix);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        double otherValue = scalar.value;
        if (otherValue != 0) {
            double result = value / otherValue;
            //double result = otherValue / value;
            return new Scalar(result);
        } else
            throw new CalcException("ERROR! Division by zero");
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        return super.div(vector);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
