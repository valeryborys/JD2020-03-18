package by.it.sinevich.jd01_08;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Scalar(double value){
        this.value=value;
    }
    public Scalar(Scalar scalar){
        this.value=scalar.value;
    }
    public Scalar(String strScalar){
        this.value=Double.parseDouble(strScalar);
    }
    @Override
    public String toString(){
        return Double.toString(value);
    }
    @Override
    public Var add(Var other){
        if(other instanceof Scalar){
            double sum=this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other){
        if(other instanceof Scalar){
            double chast = this.value - ((Scalar) other).value;
            return new Scalar(chast);
        }
        else
            return other.sub(this);
    }
    @Override
    public Var mul(Var other){
        if(other instanceof Scalar){
            double mn = this.value * ((Scalar) other).value;
            return new Scalar(mn);
        }
        else
            return other.mul(this);
    }
    @Override
    public Var div(Var other){
        if(other instanceof Scalar){
            double dv = this.value / ((Scalar) other).value;
            return new Scalar(dv);
        }
        else
            return super.div(this);
    }


}
