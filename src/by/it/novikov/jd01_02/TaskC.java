package by.it.novikov.jd01_02;

import java.util.Scanner;
import java.util.ArrayList;


public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = step1(n);
        step2(array);
        step3(array);
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean isMax = false;
        boolean isMin = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (arr[i][j] == n) {
                        isMax = true;
                    }
                    if (arr[i][j] == -n) {
                        isMin = true;
                    }
                }
            }
        }
        while (!isMax || !isMin);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        return arr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int indexOfFirstPositive = -1;
            int indexOfSecondPositive = -1;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0 && indexOfFirstPositive == -1) {
                    indexOfFirstPositive = j;
                } else if (arr[i][j] > 0 && indexOfFirstPositive != -1 && indexOfSecondPositive == -1) {
                    indexOfSecondPositive = j;
                }
            }
            if (indexOfFirstPositive != -1 && indexOfSecondPositive != -1) {
                for (int j = indexOfFirstPositive + 1; j < indexOfSecondPositive; j++) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        int max = arr[0][0];
        for (int[] lines : arr) {
            for (int value : lines) {
                if (value > max) {
                    max = value;
                }
            }
        }
        ArrayList<Integer> arrayOfLines = new ArrayList<>();
        ArrayList<Integer> arrayOfColumns = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max) {
                    if (!arrayOfColumns.contains(j)) {
                        arrayOfColumns.add(j);
                    }
                    if (!arrayOfLines.contains(i)) {
                        arrayOfLines.add(i);
                    }
                }
            }
        }
        int linesInNewArr = arr.length - arrayOfLines.size();
        int rowsInNewArr = arr[0].length - arrayOfColumns.size();
        int[][] newArr = new int[linesInNewArr][rowsInNewArr];
        int line = 0;
        for (int i = 0; i < arr.length; i++) {
            int col = 0;
            if (!arrayOfLines.contains(i)) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!arrayOfColumns.contains(j)) {
                        newArr[line][col++] = arr[i][j];
                    }
                }
                line++;
            } else {
                continue;
            }
        }
        for (int[] array : newArr) {
            for (int a : array) {
                System.out.print(a + " ");
            }
            System.out.print("\n");
        }
        return newArr;
    }
}

