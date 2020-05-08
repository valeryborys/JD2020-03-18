package by.it.szamostyanin.jd01_03;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min = 0;
        for (double v : arr) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = 0;
        for (double v : arr) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] array = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                array[i] = array[i] + matrix[i][j] * vector[j];
            }
        }
        return array;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] array = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    array[i][j] = array[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return array;
    }

    static void sort(double[] arr) {
        Arrays.sort(arr);
    }
}