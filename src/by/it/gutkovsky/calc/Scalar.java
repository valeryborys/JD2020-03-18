package by.it.gutkovsky.calc;

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
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double resultSum = this.value + otherValue;
            return new Scalar(resultSum);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double resultSub = this.value - otherValue;
            return new Scalar(resultSub);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double resultMult = this.value * otherValue;
            return new Scalar(resultMult);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar){
            if (((Scalar) other).value ==0 ) throw new CalcException("Division by zero is impossible");
            double otherValue = ((Scalar) other).value;
            if (otherValue !=0 ) {
                double resultDiv = this.value / otherValue;
                return new Scalar(resultDiv);
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
