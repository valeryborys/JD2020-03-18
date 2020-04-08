package by.it.akhmelev.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(String strValue) {
        //{1,2.0, 3, 7}
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public Var add(Var other) {
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
                System.out.println("Incompatible size");
                return null;
            }
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] += otherValue[i];
            }
            return new Vector(vectorValue);
        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        //TODO StringBuilder
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}
