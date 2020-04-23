package by.it.tolstik.jd01_05;

import java.util.Arrays;

class TaskC2 {
    public static void main(String[] args) {
        double[] a = getArray();
        printArray(a, "A");
        double[] b = sortArrayAndOperation(a,10);
        printArray(b,"B");
        printArrayWithSymbols(a,"A");
    }

    static double[] getArray() {
        double[] arr = new double[31];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 103 + (int) (Math.random() * 347);
        }
        return arr;
    }

    static void printArray(double[] arr, String name) {
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%s[%2d]=%.1f ", name, j, arr[j]);
            if ((j + 1) % 5 == 0 || j + 1 == arr.length) {
                System.out.println();
            }
        }
        System.out.println();
    }

    static double[] sortArrayAndOperation(double[] arr, double percent) {
        double[] temp = new double[31];
        int count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] / percent > i) {
                temp[j] = arr[i];
                j++;
                count++;
            }
        }
        double[] b = new double[count];
        System.arraycopy(temp, 0, b, 0, b.length);
        Arrays.sort(b);
        return b;
    }
    static void printArrayWithSymbols(double[] arr,String name) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("╔═════════════╗\n");
            System.out.printf("║ %s[%2d]=%.1f ║\n",name,i,arr[i]);
            System.out.printf("╚═════════════╝\n");
        }
    }
}

