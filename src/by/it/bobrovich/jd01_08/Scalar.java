package by.it.bobrovich.jd01_08;

public class Scalar extends Var{
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        value = scalar.value;
    }

    public Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }else return this.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }else return this.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
