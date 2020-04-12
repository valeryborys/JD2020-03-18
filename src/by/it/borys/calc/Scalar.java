package by.it.borys.calc;

class Scalar extends Var {

   private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar (Scalar scalar){
        this.value = scalar.value;
    }

    Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
       if (other instanceof Scalar){
           double sum = this.value+((Scalar) other).value;
           return new Scalar(sum);
       }
       else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).value!=0){
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


}
