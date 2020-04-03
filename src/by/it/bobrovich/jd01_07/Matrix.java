package by.it.bobrovich.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    public Matrix(String strMaxtrix) {

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
            }else{
                matrix.append("}");
            }
        }
        return matrix.toString();
    }
}
