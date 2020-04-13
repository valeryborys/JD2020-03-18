package by.it.tolstik.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Scalar) other).getValue();
            }
            return new Vector(sum);
        } else if ((other instanceof Vector) & (value.length == ((Vector) other).value.length)) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Vector) other).value[i];
            }
            return new Vector(sum);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else if ((other instanceof Vector) & (value.length == ((Vector) other).value.length)) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= ((Scalar) other).getValue();
            }
            return new Vector(mul);
        } else if ((other instanceof Vector) & (value.length == ((Vector) other).value.length)) {
            double[] mul = Arrays.copyOf(value, value.length);
            double mulSum = 0;
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= ((Vector) other).value[i];
                mulSum += mul[i];
            }
            return new Scalar(mulSum);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if ((other instanceof Scalar) && (((Scalar) other).getValue() != 0)) {
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] /= ((Scalar) other).getValue();
            }
            return new Vector(div);
        } else return super.div(other);
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value,vector.value.length);
    }

    Vector(String strVector) {
        String newString = strVector.replaceAll("[{}]"," ").replaceAll("\\,"," ").replaceAll("  "," ");
        String[] strings = newString.trim().split(" ");
        double[] doubles = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        this.value = doubles;

    }
    @Override
    public String toString() {
        return Arrays.toString(value).replaceAll("\\[","{").replaceAll("\\]","}");
    }
}
