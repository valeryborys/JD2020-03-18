package by.it.lemesh.jd01_04;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] array;
        array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int firstIndex = binarySearch(array, first);
        System.out.println("Index of first element=" + firstIndex);
        int lastIndex = binarySearch(array, last);
        System.out.println("Index of last element=" + lastIndex);
    }

    private static void mergeSort(double[] array) {
        double[] arrayA = new double[array.length / 2];
        double[] arrayB = new double[array.length - array.length / 2];
        if (array.length < 2) {
            return;
        }
        System.arraycopy(array, 0, arrayA, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, arrayB, 0, array.length - array.length / 2);
        mergeSort(arrayA);
        mergeSort(arrayB);
        array = merge(array, arrayA, arrayB);
    }

    private static void mergeSort(double[] arrayOld, int left, int right) {
        if (right > left) {
            int mid = (left + right) / 2;
            double[] arrayA = new double[mid];
            double[] arrayB = new double[right - mid];
            double[] array = new double[arrayA.length + arrayB.length];
            if (array.length < 2) {
                return;
            }
            System.arraycopy(arrayOld, left, arrayA, 0, mid);
            System.arraycopy(arrayOld, mid + 1, arrayB, 0, right - mid);
            mergeSort(arrayA);
            mergeSort(arrayB);
            array = merge(array, arrayA, arrayB);
        }
    }

    private static double[] merge(double[] array, double[] part1, double[] part2) {
        int part1Index = 0, part2Index = 0;
        for (int i = 0; i < (part1.length + part2.length); i++) {
            if (part1Index == part1.length) {
                array[i] = part2[part2Index];
                part2Index++;
            } else if (part2Index == part2.length) {
                array[i] = part1[part1Index];
                part1Index++;
            } else if (part1[part1Index] < part2[part2Index]) {
                array[i] = part1[part1Index];
                part1Index++;
            } else {
                array[i] = part2[part2Index];
                part2Index++;
            }
        }
        return array;
    }

    private static int binarySearch(double[] array, double value) {
        int first = 0;
        int last = array.length - 1;
        int mid;
        while (first <= last) {
            mid = (first + last) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                first = mid + 1;
            } else if (array[mid] > value) {
                last = mid - 1;
            }
        }
        return -1;
    }
}
