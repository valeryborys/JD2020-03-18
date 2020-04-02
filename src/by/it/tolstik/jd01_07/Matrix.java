package by.it.tolstik.jd01_07;

import java.util.Arrays;

class Matrix extends Var{
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix) {
        String[] strings = strMatrix.trim().split("},");

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll("[{ }]","");
        }
//        System.out.println(Arrays.toString(strings));
        double[][] doubles = new double[strings.length][strings.length];

        for (int i = 0; i < doubles.length; i++) {
            String[] finish = strings[i].trim().split(",");
            int count = 0;
            for (int j = 0; j < doubles[i].length; j++) {
                while (count <= 1) {
                    doubles[i][j] = Double.parseDouble(finish[count]);
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(doubles));
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value).replaceAll("\\[","{").replaceAll("\\]","}");
    }
}
