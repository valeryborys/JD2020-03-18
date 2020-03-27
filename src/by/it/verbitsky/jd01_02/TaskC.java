package by.it.verbitsky.jd01_02;

import java.util.Scanner;

public class TaskC {
    static int[][] step1(int n) {
        boolean flag1 = false;
        boolean flag2 = false;
        int cur = 0;
        int[][] array = new int[n][n];

        do {
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    cur = (int) (Math.random() * (n + n + 1)) - n;
                    array[i][j] = cur;
                    if (cur == n) flag1 = true;
                    if (cur == -n) flag2 = true;
                }
            }
        }
        while (!flag1 & !flag2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        return array;
    }

    static int step2(int[][] mas) {

        int sum = 0;

        for (int i = 0; i < mas.length; i++) {
            int index1 = -1;
            int index2 = -1;
            for (int j = 0; j < mas.length; j++) {
                //если элемент строки положительный
                if (mas[i][j] > 0) {
                    //если индексы равны между собой - значит это первый положительный элемент
                    if (index1 == index2) {
                        index1 = j;
                        continue;
                    }
                    //если индексы не равны, значит 1-й индекс был изменен
                    if (index1 != index2) {
                        //если индексы различаются больше чем на 1 - значит между ними есть число
                        if (j - index1 > 1) {
                            index2 = j;
                            for (int k = index1 + 1; k < index2; k++) {
                                sum = sum + mas[i][k];
                            }
                            break;
                        }
                    }

                }
            }
            System.out.println();
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] array) {
        int count = array.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        boolean [] delRow = new boolean[array.length];
        boolean [] delCol = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length ; j++) {
                if (array[i][j] ==max) {
                    delRow [i] = true;
                    delCol [j] = true;
                }
            }
        }

        int nRow =0;
        int nCol =0;

        for (boolean del : delRow) if (!del) nRow++;
        for (boolean del : delCol) if (!del) nCol++;

        int [][] result = new int[nRow][nCol];

        int ir = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRow [i]) {
                int ic =0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        result[ir][ic++] = array[i][j];
                    }
                }
                ir++;
            }
        }
        return  result;

    /*
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    count--;
                    for (int k = 0; k < mas.length; k++) {
                        mas[k][j] = 99;
                        mas[i][k] = 99;
                    }
                    break;
                }
            }
        }

       // System.out.println("обнуленная (max ) исходная матрица:");
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        //System.out.println("размерность новой матрицы = "+ count);
        int[][] array = new int[count+1][count+1];
        int row = 0;
        int col = 0;
        boolean flag1;

        for (int i = 0; i < mas.length; i++) {
            flag1 = false;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] != 99) {

                    array[row][col] = mas[i][j];
                    col++;
                    flag1=true;
                }
            }
           // System.out.println(flag1);
            //System.out.println("row = "+row +" col = "+col);
            if (flag1) {
                row++;
                col=0;
            }
        }
        //System.out.println("new matrix:");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    */
       // return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] mas = step1(count);
        System.out.println();
        step2(mas);
        step3(mas);
        //int [][] mas2 = step3(mas);
    }
}
