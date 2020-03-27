package by.it.tolstik.jd01_04;

import java.util.Arrays;

class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("1 2 3");

    }

    static void buildOneDimArray(String line) {
        String[] lineArr = line.trim().split(" ");
        double[] arr = new double[lineArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(lineArr[i]);
        }
        double indexFirst = arr[0];
        double indexLast = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%.2f ", "V", i, arr[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Массив после сортировки:");
        int last = arr.length - 1;
        boolean swap;
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

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%.2f ", "V", i, arr[i]);
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == indexFirst) {
                System.out.println("first element=" + i);
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == indexLast) {
                System.out.println("last element=" + i);
                break;
            }
        }
        System.out.println();

    }

    static void mergeSort(double[] array) {
        Arrays.sort(array);
    }

    static int binarySearch(double[] array, double value) {
        return Arrays.binarySearch(array, value);
    }
}
