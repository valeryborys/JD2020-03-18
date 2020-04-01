package by.it.bobrovich.jd01_04;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        String line1 = "5 4 7 2 1 10 8 9";
        buildOneDimArray(line1);
        //printArray(mas);
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

    private static void buildOneDimArray(String line) {
        double[] array = getArray(line);
        printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        System.out.println();
        mergeSort(array);
        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));

        printArray(array, "V", 3);
    }

    static void printArray(double[] array, String name, int columnCount) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count != columnCount) {
                count += 1;
                System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            } else {
                count = 1;
                System.out.println();
                System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            }
        }
    }

    static double[] getArray(String line) {
        String[] array = line.split(" ");
        double[] array1 = new double[array.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Double.parseDouble(array[i]);
        }
        return array1;
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
