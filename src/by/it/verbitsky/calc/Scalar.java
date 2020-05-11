package by.it.verbitsky.calc;

//class Scalar extends Var implements ScalarOperations {
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    //------------------------------------------------------------------------------

    //Сложение

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() + ((Scalar) other).getValue());
        } else {
            return other.add(this);
        }
    }

    //Вычитание
    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() - ((Scalar) other).getValue());
        } else {
            Var otherMinus = other.mul(new Scalar(-1));
            return otherMinus.add(this);
        }
    }

    //Умножение
    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() * ((Scalar) other).getValue());
        } else {
            return other.mul(this);
        }
    }

    //Деление
    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0)
                return new Scalar(this.getValue() / ((Scalar) other).getValue());
        }
        return super.div(other);
    }
}


























