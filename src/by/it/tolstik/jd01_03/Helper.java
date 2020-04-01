package by.it.tolstik.jd01_03;


class Helper {
    /**
     *
     * @param arr array
     * @return minimal element in array
     */
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        if (arr.length == 0) {
            System.out.println("Ошибка, нулевой массив.");
        } else {
            for (double element : arr) {
                if (min > element) {
                    min = element;
                }
            }
        }
        System.out.println();
        return min;
    }

    /**
     *
     * @param arr array
     * @return maximum element in array
     */
    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        if (arr.length == 0) {
            System.out.println("Ошибка, нулевой массив.");
        } else {
            for (double element : arr) {
                if (max < element) {
                    max = element;
                }
            }
        }
        System.out.println();
        return max;
    }

    /**
     *
     * @param arr array to sort
     */
    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    /**
     *
     * @param matrix matrix
     * @param vector array
     * @return multiplication matrix on vector
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] arr = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                arr[i] += matrix[i][j] * vector[j];
        return arr;
    }

    /**
     *
     * @param matrixLeft matrix
     * @param matrixRight matrix
     * @return multiplication matrix on matrix
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] arr = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    arr[i][j] += matrixLeft[i][k] * matrixRight[k][j];
        return arr;
    }

}
