package by.it.bobrovich.jd01_07;

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
        StringBuilder line = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[^, 0-9]");
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            int position = matcher.start();
            line.setCharAt(position, ' ');
        }
        String[] value = line.toString().trim().split(",");
        this.value = Arrays.copyOf(this.value, value.length);
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Double.parseDouble(value[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                line.append(value[i]).append(", ");
            } else {
                line.append(value[i]).append("}");
            }
        }
        return line.toString();
    }
}
