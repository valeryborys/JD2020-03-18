package by.it.szamostyanin.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * (2 * n + 1) - n); //?
                if (matrix[i][j]==n)
                    if (matrix[i][j]==n*-1)
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        //реализовать генератор случайных чисел

        //генерация ..... от -n до n

        //определение флагов f1 f2

        //заполнение матрицы
    }
}