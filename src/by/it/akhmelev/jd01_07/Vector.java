package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Vector extends Var{

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
    public String toString() {
        //TODO StringBuilder
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}
