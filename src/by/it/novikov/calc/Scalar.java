package by.it.novikov.calc;

class Scalar extends Var implements Operation {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

     Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

     Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException{
         if (other instanceof Scalar){
             double result = this.value + ((Scalar) other).value;
             return new Scalar(result);
         }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException{
         if (other instanceof Scalar){
             double result = this.value - ((Scalar) other).value;
             return new Scalar(result);
         }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException{
         if (other instanceof Scalar){
             double result = this.value * ((Scalar) other).value;
             return new Scalar(result);
         }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar){
            if(((Scalar) other).value==0)
                throw new CalcException("Деление на ноль");
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        return super.div(other);
    }
}