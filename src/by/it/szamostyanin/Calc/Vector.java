package by.it.szamostyanin.Calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.getVector(), vector.getVector().length);
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");
        String[] strings = strVector.split("\\D");
        double[] res = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            res[i]=Double.parseDouble(strings[i]);
        }
        this.value = res;
    }

    public double[] getVector() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i != value.length - 1) {
                sb.append(value[i]);
                sb.append(", ");
            }
            if (i == value.length - 1) {
                sb.append(value[i]);
                sb.append("}");
            }
        }
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            Vector operandVector = new Vector((Vector) other);
            double[] res = new double[this.getVector().length];
            if (operandVector.getVector().length == this.getVector().length) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = this.getVector()[i] + operandVector.getVector()[i];
                }
                return new Vector(res);
            } else {
                return super.add(other);
            }
        } else {
            if (other instanceof Scalar) {
                double[] res = Arrays.copyOf(this.getVector(), this.getVector().length);
                double scalar = ((Scalar) other).getValue();
                for (int i = 0; i < res.length; i++) {
                    res[i] += scalar;
                }
                return new Vector(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Vector) {
            Vector operandVector = new Vector((Vector) other);
            double[] res = new double[this.getVector().length];
            if (operandVector.getVector().length == this.getVector().length) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = this.getVector()[i] - operandVector.getVector()[i];
                }
                return new Vector(res);
            } else {
                return super.sub(other);
            }
        } else {
            if (other instanceof Scalar) {
                double[] res = Arrays.copyOf(this.getVector(), this.getVector().length);
                double scalar = ((Scalar) other).getValue();
                for (int i = 0; i < res.length; i++) {
                    res[i] -= scalar;
                }
                return new Vector(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Vector) {
            Vector operandVector = new Vector((Vector) other);
            double res = 0;
            if (operandVector.getVector().length == this.getVector().length) {
                for (int i = 0; i < operandVector.getVector().length; i++) {
                    res += this.getVector()[i] * operandVector.getVector()[i];
                }
                return new Scalar(res);
            } else {
                return super.mul(other);
            }
        } else {
            if (other instanceof Scalar) {
                double[] res = Arrays.copyOf(this.getVector(), this.getVector().length);
                double scalar = ((Scalar) other).getValue();
                for (int i = 0; i < res.length; i++) {
                    res[i] *= scalar;
                }
                return new Vector(res);
            }
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double scalar = ((Scalar) other).getValue();
                double[] res = Arrays.copyOf(this.getVector(), this.getVector().length);
                for (int i = 0; i < res.length; i++) {
                    res[i] /= scalar;
                }
                return new Vector(res);
            }
        }
        return super.div(other);
    }
}