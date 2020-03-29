package by.it.bobrovich.jd01_02;


import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int array[][] = step1(n);
        step3(array);
    }

    private static int[][] step1(int n) {
        boolean one = true;
        boolean two = true;
        boolean three = true;
        int array[][] = new int[n][n];
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (array[i][j] == n) {
                        one = false;
                    }
                    if (array[i][j] == -n) {
                        two = false;
                    }

                }
            }
            if (!one && !two) {
                three = false;
            }
        } while (three);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        return array;
    }

    private static int step2(int[][] array) {
        int sum = 0;
        int check = 0;
        int firstEl = 0;
        int secondEl = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 0) {
                    check += 1;
                    if (check == 1) {
                        firstEl = j;
                    } else if (check == 2) {
                        secondEl = j;
                    } else {
                        break;
                    }
                }
            }
            if (check == 2) {
                for (int j = firstEl + 1; j < secondEl; j++) {
                    sum += array[i][j];
                }
            }
            System.out.println(sum);
            check = 0;
        }


        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        int counti = 0;
        int countj = 0;
        boolean strok[] = new boolean[mas.length];
        boolean stolb[] = new boolean[mas.length];
        for (int i = 0; i < strok.length; i++) {
            stolb[i] = true;
            strok[i] = true;
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (max < mas[i][j]) {
                    max = mas[i][j];
                }
            }
        }
        System.out.println(max);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(max == mas[i][j]){
                    strok[i] = false;
                    stolb[j] = false;
                }
            }
        }

        for (int i = 0; i < strok.length; i++) {
            if(strok[i]){
                counti += 1;
            }
            if(stolb[i]){
                countj += 1;
            }
        }

        int newArray[][] = new int[counti][countj];

        for (int i = 0, k = 0; i < mas.length; i++) {
            if(!strok[i]){
                continue;
            }
            for (int j = 0, l = 0; j < mas.length; j++) {
                if(!stolb[j]){
                    continue;
                }
                newArray[k][l] = mas[i][j];
                l++;
            }
            k++;
        }

        for (int i = 0; i < counti; i++) {
            for (int j = 0; j < countj; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
        return newArray;
    }


}
