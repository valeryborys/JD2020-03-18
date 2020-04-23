package by.it.szamostyanin.jd01_04;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min = 0;
        for (double v : arr) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = 0;
        for (double v : arr) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }

    static void sort(double[] arr) {
        Arrays.sort(arr);
    }
}