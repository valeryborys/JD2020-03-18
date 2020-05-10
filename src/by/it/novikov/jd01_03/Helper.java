package by.it.novikov.jd01_03;

public class Helper {

    /**
     * Находит минимальное значение массива
     * @param arr - массив типа double
     * @return - минимальное значение массива
     */
    static double findMin(double[ ] arr){
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        else {
            double min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min ){
                    min = arr[i];
                }
            }
            return min;
        }


    }

    /**
     * Находит максимальное значение массива
     * @param arr - массив типа double
     * @return - максимальное значение массива
     */
    static double findMax(double[ ] arr){
        if (arr.length == 0){
            return Integer.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i]> max){
                    max = arr[i];
                }
            }
            return max;
        }
    }

    /**
     * Сортирует массив по возрастанию
     * @param arr массив типа double
     */
    static void sort(double[ ] arr){
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i]>arr[i+1]){
                    double temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = true;
                }
            }

        }
        while (swap);
    }

    /**
     * Умножает матрицу на вектор
     * @param matrix - матрица
     * @param vector - вектор
     * @return результат умножения
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    /**
     * Умножает матрицы
     * @param matrixLeft - первая матрица
     * @param matrixRight - вторая матрица
     * @return - результат умножения
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }

        }
        return result;
    }
}