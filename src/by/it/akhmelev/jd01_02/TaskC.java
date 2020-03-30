package by.it.akhmelev.jd01_02;

import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        int[][] ints = step1(3);
        System.out.println(Arrays.deepToString(ints));
    }

    static int[][] step1(int n) {
        int[][] array = new int[n][n];
        boolean okMax ;
        boolean okMin ;
        do {
            okMax = false;
            okMin = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (array[i][j]==n) okMax=true;
                    if (array[i][j]==-n) okMin=true;
                }
            }
        }
        while (!okMax || !okMin);
        return array;
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
