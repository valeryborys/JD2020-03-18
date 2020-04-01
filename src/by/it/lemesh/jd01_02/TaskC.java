package by.it.lemesh.jd01_02;

import java.util.*;

public class TaskC {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas;
        int[][] mas2;
        mas = step1(n);
        sum = step2(mas);
        mas2 = step3(mas);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        int a = 0;
        int b = 0;
        boolean flag1 = false;
        boolean flag2 = false;

        while ((!flag1) | (!flag2)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (n + n + 1)) - n;
                    if (mas[i][j] == n) {
                        flag1 = true;
                    }
                    if (mas[i][j] == -n) {
                        flag2 = true;
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

    private static int step2(int[][] mas) {
        int sum = 0;
        int x1 = -1;
        int x2 = -1;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > 0) {
                    if ((x2 < 0) && (x1 != -1))
                        x2 = j;
                    if (x1 < 0)
                        x1 = j;
                }
            }
            if ((x2 - x1) > 1) {
                for (int j = (x1 + 1); j < x2; j++) {
                    sum = sum + mas[i][j];
                }
            }
            x1 = -1;
            x2 = -1;
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        ArrayList<Integer> arrayI = new ArrayList<>();
        ArrayList<Integer> arrayJ = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        System.out.println();
        for (int i = 0; i < mas.length; i++) {
            arrList.add(new ArrayList<Integer>());
            for (int j = 0; j < mas[0].length; j++) {
                arrList.get(i).add(j, mas[i][j]);
            }
        }

        for (int i = 0; i < arrList.size(); i++) {
            for (int j = 0; j < arrList.get(0).size(); j++) {
                if (arrList.get(i).get(j) > max) {
                    max = arrList.get(i).get(j);
                }
            }
        }

        for (int i = 0; i < arrList.size(); i++) {
            for (int j = 0; j < arrList.get(0).size(); j++) {
                if (arrList.get(i).get(j) == max) {
                    if (!arrayI.contains(i))
                        arrayI.add(i);
                    if (!arrayJ.contains(j))
                        arrayJ.add(j);
                }
            }
        }

        Collections.sort(arrayI);
        Collections.sort(arrayJ);

        for (int i = 0; i < arrayI.size(); i++) {
            arrList.remove(arrayI.get(i) - i);
        }

        for (int i = 0; i < arrayJ.size(); i++) {
            for (int j = 0; j < arrList.size(); j++) {
                arrList.get(j).remove(arrayJ.get(i) - i);
            }
        }

        int[][] newmas = new int[arrList.size()][arrList.get(0).size()];
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = 0; j < arrList.get(0).size(); j++) {
                newmas[i][j] = arrList.get(i).get(j);
                System.out.print(newmas[i][j] + " ");
            }
            System.out.println();
        }
        return newmas;
    }
}
