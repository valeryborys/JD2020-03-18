package by.it.bobrovich.jd01_07;

import java.util.Arrays;

public class Vector {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        value = vector.value;
    }

    public Vector(String strVector) {

    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
