package by.it.lemesh.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(String strValue) {
        strValue = strValue.replaceAll("}", "");
        strValue = strValue.replace('{', ' ').trim();
        String[] str = strValue.split(",");
        this.value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            this.value[i] = Double.parseDouble(str[i]);
        }
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String s = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(s).append(value[i]);
            s = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}