package by.it.szamostyanin.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas = step1(n);
        step1(n);
        step2(mas);
        step3(mas);

    }

    private static int[][] step1(int n) {
        int[][] matrix = new int[n][n];
        boolean state1 = false; //задаем исходное значение false
        boolean state2 = false;
        while ((!state1) | (!state2)) { //!state1 = state1==false     !true==false
            state1 = false; //обнуляем состояние, для дальнейшей генерации
            state2 = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (matrix[i][j] == n) {
                        state1 = true;
                    }
                    if (matrix[i][j] == -1 * n) {
                        state2 = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        return matrix;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        int first,second;
        for (int i = 0; i < mas.length; i++) {
            first = 0;
            second = 0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0) {    //находим первый положительный элемент
                    first = j;
                    break;
                }
            }
            for (int j = first + 1; j < mas.length; j++) {
                if (mas[i][j] > 0) {    //находим второй положительный элемент
                    second = j;
                    break;
                }
            }
            for (int j = first + 1; j < second; j++) {
                sum += mas[i][j];   //находим их сумму
            }
        System.out.println("Sum = " + sum);
    }
        return sum;
}

    static int[][] step3(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        boolean[] delRow = new boolean[array.length];
        boolean[] delCol = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int nRow = 0;
        int nCol = 0;
        for (boolean del : delRow) if (!del) nRow++;
        for (boolean del : delCol) if (!del) nCol++;

        int[][] result = new int[nRow][nCol];

        int ir = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRow[i]) {
                int ic = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        result[ir][ic++] = array[i][j];
                    }
                }
                ir++;
            }
        }
        return result;
    }
}