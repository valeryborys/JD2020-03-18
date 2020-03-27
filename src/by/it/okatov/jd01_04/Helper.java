package by.it.okatov.jd01_04;

import java.util.Arrays;

public class Helper {

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


    static void mergeSortIterative(double[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            for (int j = 0; j < arr.length - i; j += 2 * i) {
                merge(arr, j, j + i, Math.min(j + 2 * i, arr.length));
            }
        }
    }

    private static double[] merge(double[] arr, int left, int mid, int right) {
        int iter1 = 0;
        int iter2 = 0;
        double[] result = new double[right - left];

        while ((left + iter1 < mid) && (mid + iter2 < right)) {
            if (arr[left + iter1] < arr[mid + iter2]) {
                result[iter1 + iter2] = arr[left + iter1];
                iter1++;
            } else {
                result[iter1 + iter2] = arr[mid + iter2];
                iter2++;
            }
        }

        while (left + iter1 < mid) {
            result[iter1 + iter2] = arr[left + iter1];
            iter1++;
        }
        while (mid + iter2 > right) {
            result[iter1 + iter2] = arr[mid + iter2];
            iter2++;
        }

        for (int i = 0; i < iter1 + iter2; i++) {
            arr[left + i] = result[i];
        }

        return result;
    }

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
