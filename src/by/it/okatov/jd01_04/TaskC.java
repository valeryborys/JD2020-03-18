package by.it.okatov.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    /***
     * UNUSED
     * @param array
     * @return
     */
    static double[] generate(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 20 * Math.random() - 1;
        }

        return array;
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        int indexFirst = binarySearch(array, first);
        System.out.printf("Index of first element=%d%n", indexFirst);
        int indexLast = binarySearch(array, last);
        System.out.printf("Index of last element=%d%n", indexLast);
    }


    private static int binarySearch(double[] array, double key) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    static void mergeSort(double[] array) {
        Helper.mergeSortIterative(array);
    }


}
