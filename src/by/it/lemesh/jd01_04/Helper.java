package by.it.lemesh.jd01_04;

import java.util.Arrays;

class Helper {
    static double findMin(double[] arr) {
        if (arr != null) {
            Arrays.sort(arr);
        }
        return arr[0];
    }

    static double findMax(double[] arr) {
        if (arr != null) {
            Arrays.sort(arr);
        }
        return arr[arr.length - 1];
    }

    static void sort(double[] arr) {
        double temp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return z;
    }
}
