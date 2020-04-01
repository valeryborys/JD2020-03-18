package by.it.okatov.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите размерность матрицы: ");
        int n = sc.nextInt();
        int[][] mas;
        int sumBetweenPositives;

        mas = step1(n);
        sumBetweenPositives = step2(generate(mas, n, -n));
        System.out.println("Сумма между двумя первыми положительными: " + sumBetweenPositives);
        mas = step3(generate(mas, n, -n));

        printArray(mas);
    }

    public static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean flag = false;
        boolean[] flagEquals = {false, false};

        while (!flag) {
            if (flagEquals[0] && flagEquals[1]) {
                flag = true;
            } else {
                flagEquals[0] = false;
                flagEquals[1] = false;
                /*mas =*/
                generate(mas, n, -n);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] == n) {
                        flagEquals[0] = true;
                    }
                    if (mas[i][j] == -n) {
                        flagEquals[1] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.print("\n");
        }

        return mas;
    }

    private static int[][] generate(int[][] mas, int max, int min) {
        System.out.println("\nNew generation");
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = (int) (Math.random() * (max * 2 + 1)) + min;
            }
        }
        printArray(mas);
        return mas;
    }

    public static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0) {
                    for (int k = j + 1; k < mas.length; k++) {
                        if (mas[i][k] < 0 /*&& k != mas.length*/) {
                            sum += mas[i][k];

                        } else if (mas[i][k] > 0) {
                            break;
                        }
                    }
                    break;
                }

            }

            System.out.println("String #" + i + ". Sum = " + sum);
        }

        return sum;
    }


    private static void printArray(int[][] mas) {
        for (int[] ma : mas) {
            for (int j = 0; j < mas.length; j++) {
                System.out.printf("%5d", ma[j]);
            }
            System.out.println();
        }
    }

    /*
    private static void printVector(int[] mas) {
        for (int ma : mas) {
            System.out.printf("%5d%n", ma);
        }
    }*/

    private static int[][] step3(int[][] array) {
        int max = getMax(array);

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

        for (boolean del : delRow) {
            if (!del)
                nRow++;
        }

        for (boolean del : delCol) {
            if (!del)
                nCol++;
        }

        int[][] res = new int[nRow][nCol];

        int ir = 0;

        for (int i = 0; i < array.length; i++) {
            if (!delRow[i]) {
                int ic = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][ic++] = array[i][j];

                    }
                }
                ir++;
            }
        }

        return res;
    }

    private static int getMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int elem : row) {
                if (elem > max) {
                    max = elem;
                }
            }
        }
        return max;
    }
}
