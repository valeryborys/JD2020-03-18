package by.it.borys.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i]) {
                min = mas[i];
            }
            if (max < mas[i]) {
                max = mas[i];
            }
        }
        System.out.println(min + " " + max);

    }

    private static void step2(int[] mas) {
        double sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i];
        }
        double avrg = sum / mas.length;
        //System.out.println(avrg);
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < avrg) System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int ma : mas) {
            if (min > ma) {
                min = ma;
            }
        }
            for (int j = mas.length - 1; j >= 0; j--) {
                if (mas[j] == min) {
                    System.out.print(j + " ");
                }

            }



    }

}
