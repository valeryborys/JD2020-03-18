package by.it.okatov.jd01_03;

import java.util.Arrays;

class Helper {

    /***
     * Метод для поиска минимума в массиве чисел с плавающей точкой двойной точности
     * @param arr - массив чисел
     * @return - возвращает найденый минимум
     */
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return 0.0d;
        }

        double min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    /***
     * Метод для поиска максимума в массиве чисел с плавающей точкой двойной точности
     * @param arr - массив чисел
     * @return - возвращает найденый максимум
     */
    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return 0.0d;
        }

        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /***
     * Реализация сортировки библиотечными функциями
     * @param arr - массив чисел
     */
    static void sort(double[] arr) {
        System.out.println("Not sorted array: ");
        InOut.printArray(arr);
        System.out.println("\nSorted array: ");
        Arrays.sort(arr);
    }

    /***
     *
     * @param arr Передаваемый массив
     * @param sortType Тип сортировки: Bubble - пузырьковая, Select - выбором, Insert - вставками
     */
    static void sort(double[] arr, String sortType) {
        switch (sortType) {
            case "Bubble":
                InOut.printArray(bubbleSort(arr), "B", 5);
                break;
            case "Select":
                InOut.printArray(selectSort(arr), "S", 5);
                break;
            case "Insert":
                InOut.printArray(insertSort(arr), "I", 5);
                break;
            default:
                InOut.printArray(bubbleSort(arr), "B", 5);
                break;
        }
    }

    /***
     * Сортировка пузырьком
     * @param arr - массив чисел
     * @return - отсортированный массив чисел
     */
    static double[] bubbleSort(double[] arr) {
        boolean bFlag = false;

        int last = arr.length - 1;
        double dSwap;

        do {
            bFlag = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    dSwap = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = dSwap;
                    bFlag = true;
                }
            }
        } while (bFlag);

        return arr;
    }

    /***
     * Сортировка выбором
     * @param arr - массив чисел
     * @return - отсортированный массив чисел
     */
    static double[] selectSort(double[] arr) {
        int end = 0;
        double dSwap;
        for (int start = 0; start < arr.length - 1; start++) {
            end = start;
            for (int j = start + 1; j < arr.length; j++) {
                if (arr[j] < arr[end]) {
                    end = j;
                }
            }
            dSwap = arr[start];
            arr[start] = arr[end];
            arr[end] = dSwap;
        }

        return arr;
    }

    /***
     * Сортировка вставками
     * @param arr - массив чисел
     * @return - отсортированный массив чисел
     */
    static double[] insertSort(double[] arr) {
        double value;
        int j = 0;
        for (int left = 1; left < arr.length; left++) {
            value = arr[left];
            j = left;
            while (j > 0 && value < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = value;
        }

        return arr;
    }


    /***
     * Метод для умножения матрицы на вектор
     * @param matrix - входная матрица
     * @param vector - входной вектор
     * @return - результат умножения: выходной вектор
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] resMatrix = new double[matrix.length];

        if (matrix[0].length != vector.length) {
            return null;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resMatrix[i] += matrix[i][j] * vector[j];
            }
        }

        return resMatrix;
    }


    /***
     * Метод для умножения матрицы на матрицу
     * @param matrixRight - первая входная матрица (множимое)
     * @param matrixLeft - вторая входная матрица(множитель)
     * @return - возвращает результат умножения: новую матрицу
     */
    static double[][] mul(double[][] matrixRight, double[][] matrixLeft) {
        double[][] resMatrix = new double[matrixRight.length][matrixLeft[0].length];

        if (matrixRight.length != matrixLeft[0].length) {
            return null;
        }

        for (int i = 0; i < matrixRight.length; i++) {
            for (int j = 0; j < matrixLeft[0].length; j++) {
                for (int k = 0; k < matrixLeft.length; k++) {
                    resMatrix[i][j] += matrixRight[i][k] * matrixLeft[k][j];
                }
            }
        }
        return resMatrix;
    }
}
