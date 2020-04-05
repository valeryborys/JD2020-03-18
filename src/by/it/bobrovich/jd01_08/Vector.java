package by.it.bobrovich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int position = matcher.start();
            sb.setCharAt(position, ' ');
        }
        String[] vector = sb.toString().trim().split(",");
        double[] value1 = new double[vector.length];
        for (int i = 0; i < value1.length; i++) {
            value1[i] = Double.parseDouble(vector[i]);
        }
        value = Arrays.copyOf(value1, value1.length);

    }

    @Override
    public Var add(Var other) {
        double[] newVector = new double[this.value.length];
        if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    for (double aValue : ((Vector) other).value) {
                        newVector[i] = this.value[i] + ((Vector) other).value[i];
                    }
                }
            }
            return new Vector(newVector);
        } else if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++) {
                newVector[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return new Vector(newVector);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[] newVector = new double[this.value.length];
        if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    newVector[i] = this.value[i] - ((Vector) other).value[i];
                }
            }
            return new Vector(newVector);
        } else if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++) {
                newVector[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return new Vector(newVector);
        } else return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        double[] newVector = new double[this.value.length];
        double result = 0.0;
        if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    result += this.value[i] * ((Vector) other).value[i];
                }
            }
            return new Scalar(result);
        } else if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++) {
                newVector[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(newVector);
        } else return super.add(other);
    }

    @Override
    public Var div(Var other) {
        double[] newVector = new double[this.value.length];
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                for (int i = 0; i < this.value.length; i++) {
                    newVector[i] = this.value[i] / ((Scalar) other).getValue();
                }
                return new Vector(newVector);
            } else {
                System.out.println("Div by zero");
                return null;
            }
        } else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder();
        vector.append("{");
        for (int j = 0; j < value.length; j++) {
            if (j < value.length - 1) {
                vector.append(value[j]).append(", ");
            } else {
                vector.append(value[j]).append("}");
            }
        }
        return vector.toString();
    }
}
