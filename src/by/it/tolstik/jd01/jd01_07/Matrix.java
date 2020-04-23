package by.it.tolstik.jd01.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix) {
        String[] strings = strMatrix.trim().split(",");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll("[{ }]", "");
        }
        int count = 0;
        value = new double[strings.length / 2][strings.length / 2];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(strings[count++]);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value).replaceAll("\\[", "{").replaceAll("\\]", "}");
    }
}
