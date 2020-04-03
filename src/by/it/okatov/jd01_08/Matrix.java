package by.it.okatov.jd01_08;


import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(String strMatrix) {
        String[] strTempArray = strMatrix.split("},");


        for (int i = 0; i < strTempArray.length; i++) {
            for (char ch : strTempArray[i].toCharArray()) {
                if (ch == '{' || ch == '}') {
                    strTempArray[i] = strTempArray[i].replace(Character.toString(ch), "");
                }
            }
        }
        String[][] strTempArray2D = new String[strTempArray.length][strTempArray[0].split(",").length];
        for (int i = 0; i < strTempArray2D.length; i++) {
            for (int j = 0; j < strTempArray2D[i].length; j++) {
                strTempArray2D[i][j] = strTempArray[i].split(",")[j];
            }
        }

        value = new double[strTempArray.length][strTempArray[0].split(",").length];


        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(strTempArray2D[i][j]);
            }
        }

    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");


        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j < (value[i].length - 1)) {
                    sb.append(", ");
                } else {
                    sb.append("}");
                }
            }
            if (i < (value.length - 1)) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }
        return sb.toString();
    }
}
