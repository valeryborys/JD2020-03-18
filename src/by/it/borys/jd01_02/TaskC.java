package by.it.borys.jd01_02;

import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = sc.nextInt();
        int[][] mas = step1(n);
        step2(mas);
        step3(mas);

    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        int value = 0;
        while (value == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * 2 * (n + 1) - (n + 1));
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            int min = mas[0][0];
            int max = mas[0][0];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (min > mas[i][j]) {
                        min = mas[i][j];
                    }
                    if (max < mas[i][j]) {
                        max = mas[i][j];
                    }
                }
            }
            if (min == -n && max == n) {
                value = 1;
            } else {
                System.out.println("-n и/или n не найдены в матрице");
            }
        }
        return mas;
    }

    public static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int firstpositive = 0;
            int secondpositive = 0;
            int value = 0;
            int value2 = 0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0 && value < 1) {
                    firstpositive = j;
                    value += 1;
                }
                if (mas[i][j] > 0 && value2 < 2) {
                    secondpositive = j;
                    value2 += 1;
                }

            }
            for (int j = (firstpositive + 1); j < secondpositive; j++) {
                sum += mas[i][j];

            }

        }
        System.out.println(sum);
        return sum;
    }

    public static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (max < mas[i][j]) {
                    max = mas[i][j];
                }
            }
        }
        System.out.println(max);
        boolean[] delRow = new boolean[mas.length];
        boolean[] delCol = new boolean[mas[0].length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }

        int newRow = 0;
        int newCol = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                newRow++;
            }
            if (!delCol[i]) {
                newCol++;
            }
        }
        int[][] res = new int[newRow][newCol];
        int indexRow = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                int indexCol = 0;
                for (int j = 0; j < mas[0].length; j++) {
                    if (!delCol[j]) {
                        res[indexRow][indexCol] = mas[i][j];
                        System.out.print(res[indexRow][indexCol] + " ");
                        indexCol++;
                    }
                }
                indexRow++;
                System.out.println();
            }
            }
            return res;

    }
}