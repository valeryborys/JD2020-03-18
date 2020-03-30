package by.it.gutkovsky.jd01_03;

/**
 * @author Dmitriy Gutkovsky
 * <p>
 * Class Helper
 * <p>
 * This class contains nest methods: find min number in the array, find max number in the array, sort array, multiply array on vector, array on array
 */

 class Helper {
    /**
     * Find minimum number in incoming array
     *
     * @param arr double[] array
     * @return min  - minimum in the array
     */
    static double findMin(double[] arr) {
        // проверка длины массива ( не нулевой)
        if (arr.length <= 0) {
            System.out.println("Error: Your array has length = 0");
            return Integer.MAX_VALUE;
        } else {
            double min = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            return min;
        }
    }

    /**
     * Find maximum number in incoming array
     *
     * @param arr double[] array
     * @return max - maximum in the incoming array
     */

    static double findMax(double[] arr) {
        // проверка длины массива ( не нулевой)
        if (arr.length <= 0) {
            System.out.println("Error: Your array has length = 0");
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        }
    }

    /**
     * Sort array from minimum to maximum number and print array, which we get as result
     *
     * @param arr double[] array
     */
    static void sort(double[] arr) {
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    needIteration = true;
                }
            }
        }
        InOut.printArray(arr);

    }

    // умножение матрицы на вектор

    /**
     * Multiply double[][] matrix on double[] vector
     *
     * @param matrix double[][] array
     * @param vector double[] array
     * @return double[] multipliedMatrix
     */
    static double[] mul(double[][] matrix, double[] vector) {

        if (matrix[1].length != vector.length) {
            System.out.println("Matrix and vector cannot be multiplied. They have different length");
            return vector;
        } else {
            double[] multipliedMatrix = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    multipliedMatrix[i] = multipliedMatrix[i] + matrix[i][j] * vector[j];

                }
            }
            return multipliedMatrix;
        }
    }

    //умножение матицы на матрицу

    /**
     * Multiply double[][] matrixLeft on double[][] matrixRight)
     *
     * @param matrixLeft  double[][] array
     * @param matrixRight double[][] array
     * @return double[][] multipliedMatrix
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        if (matrixLeft[0].length != matrixRight.length) {
            System.out.println("These matrix cannot be multiplied. They have different length");
            return matrixLeft;
        } else {
            double[][] multipliedMatrix = new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixRight.length; k++) {
                        multipliedMatrix[i][j] = multipliedMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }
            return multipliedMatrix;
        }

    }
}