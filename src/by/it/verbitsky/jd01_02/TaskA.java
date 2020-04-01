package by.it.verbitsky.jd01_02;

import java.util.Scanner;

class TaskA {
    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int elem : mas) {
            if (elem < min) {
                min = elem;
            }
            if (elem > max) {
                max = elem;
            }
        }
        System.out.printf("%d %d", min, max);
    }

    private static void step2(int[] mas) {
        double mid = 0;
        for (int elem : mas) {
            mid = mid + elem;
        }
        mid = mid / mas.length;
        for (int elem : mas) {
            if (elem < mid) {
                System.out.print(elem + " ");
            }
        }
    }

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int elem : mas) {
            if (elem < min) {
                min = elem;
            }
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++)
            mas[i] = scanner.nextInt();
        step1(mas);
        step2(mas);
        step3(mas);
    }
}
