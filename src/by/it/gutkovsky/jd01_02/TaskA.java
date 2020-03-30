package by.it.gutkovsky.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

 class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();

        // print array for checking
//        for (int i = 0; i < array.length; i++){
//            System.out.print(array[i] + " ");
//       }

        step1(array);
        step2(array);
        step3(array);
    }

    static void step1(int[] array) {

        // first solution
//        Arrays.sort(array);
//        int min = array[0];
//        int max = array[array.length - 1];
//        System.out.println("min =" + min + " " + "max=" + max);

        // second solution
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
//        System.out.println("min = " + min + " " + "max = " + max);
        System.out.println(min + " " + max);
    }

    static void step2(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = sum / array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void step3(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) System.out.print(i + " ");
        }
    }

}
