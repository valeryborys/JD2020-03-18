package by.it.verbitsky.jd01_08;

import by.it.verbitsky.jd01_07.Var;

import java.util.Arrays;

class Matrix extends Var {
    public double[][] getMatrix() {
        return matrix;
    }

    private double[][] matrix;

    Matrix(double[][] value) {
        this.matrix = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this.matrix = Arrays.copyOf(matrix.getMatrix(), matrix.getMatrix().length);
    }

    Matrix(String strMatrix) {
        double[][] array = getArrayFromString(strMatrix.substring(1, strMatrix.length() - 1));
        this.matrix = Arrays.copyOf(array, array.length);
    }

    private double[][] getArrayFromString(String str) {
        String[] strings = str.split("},");
        double[][] array = new double[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            array[i] = getVectorFromString(strings[i]);
        }
        return array;
    }


    private double[] getVectorFromString(String strVector) {
        strVector = strVector.replaceAll("[{}\\s]", "");
        String[] strings = strVector.split(",");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double[] doubles : matrix) {
            stringBuilder.append("{");
            for (int j = 0; j < doubles.length; j++) {
                if (j == doubles.length - 1) {
                    stringBuilder.append(doubles[j]);
                } else {
                    stringBuilder.append(doubles[j]).append(", ");
                }
            }
            stringBuilder.append("}, ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).trimToSize();
        stringBuilder.setCharAt(stringBuilder.length() - 1, '}');
        return stringBuilder.toString();
    }
}
