package by.it.verbitsky.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] vector;

    Vector(double[] array) {
        this.vector = Arrays.copyOf(array, array.length);
    }

    Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.getVector(), vector.getVector().length);
    }

    Vector(String strVector) {
        this.vector = getVectorFromString(strVector);
    }

    private double[] getVectorFromString(String strVector) {
        strVector = strVector.replaceAll("[{}\\s]", "");
        String[] strings = strVector.split(",");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    double[] getVector() {
        return vector;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double v : getVector()) {
            stringBuilder.append(v).append(", ");
        }
        stringBuilder.setCharAt(stringBuilder.length() - 2, '}');
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).trimToSize();
        return stringBuilder.toString();
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
