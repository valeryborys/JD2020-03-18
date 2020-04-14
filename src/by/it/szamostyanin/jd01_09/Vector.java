package by.it.szamostyanin.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");
        String[] strings = strVector.split("\\D");
        double[] res = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            res[i]=Double.parseDouble(strings[i]);
        }
        this.value = res;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i != value.length - 1) {
                sb.append(value[i]);
                sb.append(", ");
            }
            if (i == value.length - 1) {
                sb.append(value[i]);
                sb.append("}");
            }
        }
        return sb.toString();
    }
}