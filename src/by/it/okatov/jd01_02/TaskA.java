package by.it.okatov.jd01_02;

import java.util.Scanner;

///Как регистр процессора воспринимает точки останова?
public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("Input 10 numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        step1(array);
        step2(array);
        System.out.println("\nIndexes of minimal elements in reverse order: ");
        step3(array);
    }

    public static void step1(int[] mas) {
        int minValue = mas[0];
        int maxValue = mas[0];

        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < minValue) {
                minValue = mas[i];
            }

            if (mas[i] > maxValue) {
                maxValue = mas[i];
            }
        }

        System.out.println(minValue + " " + maxValue);
    }

    public static void step2(int[] mas) {
        double sum = 0;

        for (int ma : mas) {
            sum += ma;
        }
        sum /= mas.length;

        for (int ma : mas) {
            if (ma < sum) {
                System.out.print(ma + " ");
            }
        }
    }

    public static void step3(int[] mas) {
        int minValue = mas[0];

        for (int ma : mas) {
            if (ma < minValue) {
                minValue = ma;
            }
        }

        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == minValue) {
                System.out.print(i + " ");
            }
        }
    }
}

