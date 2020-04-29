package by.it.szamostyanin.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);
        //step2();
        //step3();
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
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
        return matrix;
    }

    private static int step2(int[][] mas) {
        return 0;
    }

    private static int[][] step3(int[][] mas) {
        return null;
    }
}