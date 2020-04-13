package by.it.szamostyanin.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);

    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix) {
        String[] strings = strMatrix.split("},"); //strings[i] = {1,2,3}{1,2,3}{1,2,3}{1,2,3}
        double [][] mass= new double[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            mass[i] = getArrayFromString(strings[i]);
        }
        this.value=mass;
    }

    double[ ] getArrayFromString(String s) {
        s = s.replaceAll("[{}\\s]", "");
        String[] strings = s.split(",");
        double[] res = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            res[i]=Double.parseDouble(strings[i]);
        }
        return res;
    }

    @Override
    public String toString() {
        if (this.value == null) {
            System.out.println("Нулевой размер поля Value \n");
        } else {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < value.length; i++) {
                sb.append("{");
                for (int j = 0; j < value.length; j++) {
                    sb.append(value[i][j]);
                    if (j == value.length - 1) {
                        sb.append("}");
                    } else {
                        sb.append(", ");
                    }
                }
                if (i == value.length - 1) {
                    sb.append("}");
                } else {
                    sb.append(",");
                }

            }
            return sb.toString();
        }
        return null;
    }
}