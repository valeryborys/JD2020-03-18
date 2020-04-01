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


    private static void mergeSort(double[] array) {
        double[] example = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = example[i];
        }
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            return merge(mergeSort(array, left, mid), mergeSort(array, mid + 1, right));
        } else {
            double[] array1 = {array[left]};
            return array1;
        }

    }

    private static double[] merge(double part1[], double part2[]) {
        double array[] = new double[part1.length + part2.length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if (i == part1.length) {
                array[k] = part2[j];
                j++;
            } else if (j == part2.length) {
                array[k] = part1[i];
                i++;
            } else if (part1[i] < part2[j]) {
                array[k] = part1[i];
                i++;
            } else {
                array[k] = part2[j];
                j++;
            }
        }

        return array;
    }
    private static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
    }

