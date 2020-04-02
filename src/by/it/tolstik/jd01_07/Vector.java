package by.it.tolstik.jd01_07;

import java.util.Arrays;

class Vector extends Var{
    private double[] value;

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
