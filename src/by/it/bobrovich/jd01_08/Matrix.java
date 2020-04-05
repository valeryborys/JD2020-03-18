package by.it.bobrovich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    public Matrix(String strMaxtrix) {
        StringBuilder sb = new StringBuilder(strMaxtrix);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int position = matcher.start();
            sb.setCharAt(position, ' ');
        }
        String[] matrix = sb.toString().trim().split(",");
        double[][] value1 = new double[2][2];
        for (int i = 0, k = 0; i < value1.length; i++) {
            for (int j = 0; j < value1.length; j++) {
                if(k<5){
                    value1[i][j] = Double.parseDouble(matrix[k]);
                    k++;
                }
            }
        }
        value = Arrays.copyOf(value1, value1.length);
    }

    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder();
        matrix.append("{{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if (j < value.length - 1) {
                    matrix.append(value[i][j]).append(", ");
                } else {
                    matrix.append(value[i][j]).append("}");
                }
            }
            if (i < value.length - 1) {
                matrix.append(", {");
            } else {
                matrix.append("}");
            }
        }
        return matrix.toString();
    }
}
