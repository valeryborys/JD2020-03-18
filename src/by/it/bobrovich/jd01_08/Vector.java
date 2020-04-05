package by.it.bobrovich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(sb);
        while(matcher.find()){
            int position = matcher.start();
            sb.setCharAt(position, ' ');
        }
        String[] vector = sb.toString().trim().split(",");
        double[] value1 = new double[vector.length];
        for (int i = 0; i < value1.length; i++) {
            value1[i] = Double.parseDouble(vector[i]);
        }
        value = Arrays.copyOf(value1, value1.length);

    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder();
        vector.append("{");
        for (int j = 0; j < value.length; j++) {
            if (j < value.length - 1) {
                vector.append(value[j]).append(", ");
            } else {
                vector.append(value[j]).append("}");
            }
        }
        return vector.toString();
    }
}
