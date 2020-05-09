package by.it.akhmelev.calc19;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(String strValue) {
        String[] parts = strValue
                .replace("{", "")
                .replace("}","")
                .replace(" ", "")
                .split(",");
        value=new double[parts.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(parts[i]);
        }
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(value, value.length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] += otherValue;
            }
            return new Vector(vectorValue);
        } else if (other instanceof Vector) {
            double[] otherValue = ((Vector) other).value;
            double[] vectorValue = Arrays.copyOf(value, value.length);
            if (otherValue.length != vectorValue.length) {
                throw new CalcException("Incompatible size");
            }
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] += otherValue[i];
            }
            return new Vector(vectorValue);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        //TODO StringBuilder
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}
