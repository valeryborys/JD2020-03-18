package by.it.tolstik.jd01_02;

import java.util.Random;
import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] arr = new int[n][n];
        int countPlusI = 0;
        int countMinusI = 0;
        while (true) {
            countPlusI = 0;
            countMinusI = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = random.nextInt(n * 2 + 1) - n;
                    if (arr[i][j] == n) {
                        countPlusI++;
                    }
                    if (arr[i][j] == -n) {
                        countMinusI++;
                    }
                }
            }
            if (countMinusI > 0 & countPlusI > 0) break;
        }
        return arr;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length-1; j++) {
                if (mas[i][j] > 0) {

                    if (mas[i][j + 1] > 0) {
                        sum += 0;
                    } else sum += mas[i][j + 1];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] row : mas) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        boolean[] delRow = new boolean[mas.length];
        boolean[] delCol = new boolean[mas[0].length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }
        int nRow = 0;
        int nCol = 0;
        for (boolean del : delRow) {
            if (!del) nRow++;
        }
        for (boolean del : delCol) {
            if (!del) nCol++;
        }
        int[][] result = new int[nRow][nCol];
        int indexRow = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                int indexCol = 0;
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        result[indexRow][indexCol++] = mas[i][j];
                    }
                }
                indexRow++;
            }
        }

        return result;
    }
}
