package by.it.tolstik.jd01_05;

import static java.lang.Math.*;

class TaskC {
    public static void main(String[] args) {
        double[] a = getArrayA();
        printArray(a, "A");
        double[] b = sortArrayForMoreThan(a, 3.5);
        printArray(b, "B");
        avgGeometrical(b);
    }

    static double[] getArrayA() {
        double[] a = new double[40];
        int i = 0;
        for (double x = 5.33; x <= 9; x += 0.09) {
            if (i >= 40) {
                break;
            } else {
                a[i] = pow(pow(x, 2) + 4.5, 1. / 3);
                i++;
            }
        }
        return a;
    }

    static void printArray(double[] arr, String name) {
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%s[%2d]=%10.5f ", name, j, arr[j]);
            if ((j + 1) % 5 == 0 || j + 1 == arr.length) {
                System.out.println();
            }
        }
        System.out.println();
    }

    static double[] sortArrayForMoreThan(double[] arr, double num) {
        double[] temp = new double[40];
        int count = 0;
        for (int k = 0, k1 = 0; k < arr.length; k++) {
            if (arr[k] >= num) {
                temp[k1] = arr[k];
                k1++;
                count++;
            }
        }
        double[] b = new double[count];
        System.arraycopy(temp, 0, b, 0, b.length);
        return b;
    }

    static void avgGeometrical(double[] arr) {
        double sum = 0;
        for (double elem : arr) {
            sum += elem;
        }
        System.out.println(pow(sum, 1. / arr.length));
    }
}
