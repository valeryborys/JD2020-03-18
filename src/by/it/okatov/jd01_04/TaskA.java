package by.it.okatov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.printf("%n");
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double[] arraySelectSort;
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        arraySelectSort = Helper.selectSort(array);
        InOut.printArray(arraySelectSort, "V", 4);
        //InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.printf("Index of first element=%d%n", i);
                break;
            }
        }

        int indexLast = Arrays.binarySearch(array, last);
        System.out.printf("Index of last element=%d%n", indexLast);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        printMulTable();
        buildOneDimArray(line);

    }
}
