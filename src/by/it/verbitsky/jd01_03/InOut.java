package by.it.verbitsky.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InOut {
    static double[] getArray(String line) {
        line = line.trim();
        String[] stringDobles = line.split(" ");
        double[] arr = new double[stringDobles.length];
        for (int i = 0; i < stringDobles.length; i++) {
            if (!stringDobles[i].equals(" "))
                arr[i] = Double.parseDouble(stringDobles[i]);
        }
        return arr;
    }

    static String getLine() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        return buffer.readLine();
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.printf("% 4.2f", v);
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            if (i>0 & i % columnCount == 0 ) {
                System.out.println();
            }
            System.out.printf("%s[%d]: %-4.2f  ", name, i, arr[i]);
        }
        System.out.println();
    }

    static double[] mergeSort(double[] arr) {
        if (arr.length < 2) return arr;
        int m = arr.length / 2;
        double[] arr1 = Arrays.copyOfRange(arr, 0, m);
        double[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return mergeArrays(mergeSort(arr1), mergeSort(arr2));
    }

    static double[] mergeArrays(double[] masA, double[] masB) {
        int n = masA.length + masB.length;
        double[] arr = new double[n];
        int masAIndex = 0; //курсор левый массив
        int masBIndex = 0; //курсор правый массив
        for (int i = 0; i < n; i++) {
            //Если левый массив уже закончился - добираем элементы из правого
            if (masAIndex == masA.length) {
                arr[i] = masB[masBIndex];
                masBIndex++;
                // Если левый массив уже закончился - добираем элементы из правого
            } else if (masBIndex == masB.length) {
                arr[i] = masA[masAIndex];
                masAIndex++;
            } else {
                if (masA[masAIndex] < masB[masBIndex]) {
                    arr[i] = masA[masAIndex];
                    masAIndex++;
                } else {
                    arr[i] = masB[masBIndex];
                    masBIndex++;
                }
            }
        }
        return arr;
    }

}
