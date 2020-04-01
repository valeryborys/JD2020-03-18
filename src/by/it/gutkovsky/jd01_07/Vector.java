package by.it.gutkovsky.jd01_07;

import java.util.Arrays;

public class Vector extends Var{

    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public String toString() {
//        StringBuilder text = new StringBuilder("{");

        return  Arrays.toString(value);
    }
}
