package by.it.bobrovich.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String strVector) {

    }

    @Override
    public String toString() {
        //StringBuilder
        return null;
    }
}
