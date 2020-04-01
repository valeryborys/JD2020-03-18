package by.it.sinevich.jd01_02;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas= new int[n][n];
        step1(n);
        step2(step1(n));
        step3(step1(n));

    }

    public static int[][] step1(int n) {
            int[][] mas = new int[n][n];
            boolean m = false;
            boolean m1 = false;
            Gener(mas,n);
            while (m == true && m1 == true) {
                //Проходим матрицу - ищем нужные значения.
                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas.length; j++) {
                        int num = mas[i][j];
                        if (num == n) {
                            m = true;
                        } else if (num == -n) {
                            m1 = true;
                        } else
                            continue;
                    }
                }
                //конец перебора матрицы
                if (!m || !m1) {
                    Gener(mas, n);
                }
                else {
                    break;
                }
            }
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            return mas;
        }
    public static int step2(int[][] mas){
        int sum=0;
        int m1=0;
        int m2=0;
            for (int i = 0; i < mas.length; i++) {
                m1=0;
                m2=0;
                for (int a = 0; a < mas.length; a++) {
                    if(mas[i][a]>0){
                        m1=a;
                        break;
                    }
                    else if(mas[i][a]<=0){
                        continue;
                    }
                }
                for (int j = m1+1; j < mas.length; j++) {
                    if(mas[i][j]>0){
                        m2=j;
                        break;
                    }
                    else if(mas[i][j]<=0){
                        continue;
                    }
                }
                for (int h = m1+1; h < m2; h++) {
                    sum+=mas[i][h];

                }
                System.out.println(sum);
                }
            return sum;
            }

    public static int[][] step3(int[][] mas) {
        int max=0;
        ArrayList<Integer> stroka = new ArrayList<Integer>();
        ArrayList<Integer> stolbik = new ArrayList<Integer>();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j]>=max){
                    max=mas[i][j];
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j]==max){
                    stroka.add(j);
                    stolbik.add(i);
            }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(j==stroka.get(j)){
                    mas[i][j]= Integer.parseInt(null);
                }
                else
                    continue;
            }
            if(i==stolbik.get(i)){
                mas[i][i]= Integer.parseInt(null);
            }
        }
        return mas;

    }
    public static void Gener(int[][]mas, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }

    }
        }



