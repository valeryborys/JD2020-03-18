package by.it.bobrovich.jd01_02;


import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[] = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(min + " " + max);
        System.out.println();
    }

    private static void step2(int[] array) {
        double avg;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        avg = sum / (double) array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < avg) {
                System.out.println(array[i]);
            }
        }
    }

    private static void step3(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (min == array[i]){
                System.out.print(i + " ");
            }
        }
    }
}
