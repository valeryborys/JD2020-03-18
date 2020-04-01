package by.it.verbitsky.jd01_03;

public class Helper {
    static void sort(double[] arr) {
        boolean isSorted = false;
        double buf;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
    }

    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double v : arr) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double v : arr) {
            if (v > max) {
                max = v;
            }
        }
        return max;
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

    static double[] mul(double[][] matrix, double[] vector) {
        double[] array = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                array[i] = array[i] + matrix[i][j] * vector[j];
            }
        }
        return array;
    }
}
