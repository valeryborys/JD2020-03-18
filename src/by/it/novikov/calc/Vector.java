package by.it.novikov.calc;

import java.util.Arrays;

class Vector extends Var implements Operation {
    private double[] values;

    public double[] getValues() {
        return values;
    }

    public Vector(double[] values) {
        this.values = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(sb.length() -1);
        sb.deleteCharAt(0);
        String[] strArray = sb.toString().split(",");
        double[] doubleArray = new double[strArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }
        this.values = doubleArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double d : values) {
            sb.append(delimiter).append(d);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }


    @Override
    public Var add(Var other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar){
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] +=s;
            }
            return new Vector(result);
        }
         if (other instanceof Vector){
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar){
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] -=s;
            }
            return new Vector(result);
        }
        if (other instanceof Vector){
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).values[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector){
            int res = 0;
            for (int i = 0; i < values.length; i++) {
                res += values[i]*((Vector) other).getValues()[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }
}