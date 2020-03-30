package by.it.zambrano.jd01_02;

import java.util.Scanner;



public class TaskC {

    public void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        step1(n);
        int mas[][] = new int[n][n];
        int sum = 0;
    }


    private int[][] step1(int n) {
        int mas[][] = new int[n][n];
        boolean flagmax = false;
        boolean flagmin = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) Math.random() * ((2 * n) + 1) - n;
                    if (n == mas[i][j]) flagmax = true;
                    if (-n == mas[i][j]) flagmin = true;
                }
            }
        }
        while (!flagmax & !flagmin);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(mas[i][j] + " ");
            }
            System.out.println();
            return mas;
        }

        return mas;
    }
}