package by.it.lemesh.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] namesArr = new String[n];
        int[][] salaryArr = new int[n][4];
        for (int i = 0; i < n; i++) {
            namesArr[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + namesArr[i]);
            for (int j = 0; j < 4; j++) {
                salaryArr[i][j] = sc.nextInt();
            }
        }
        printSalary(namesArr, salaryArr);
    }

    private static void printSalary(String[] namesArr, int[][] salaryArr) {
        int sum = 0;
        int total = 0;
        System.out.print("--------------------------------------------------------------");
        System.out.println();
        System.out.println("  Фамилия   Квартал1   Квартал2   Квартал3   Квартал4   Итого");
        System.out.print("--------------------------------------------------------------");
        System.out.println();
        for (int i = 0; i < namesArr.length; i++) {
            System.out.printf("%8s:", namesArr[i]);
            for (int j = 0; j < salaryArr[0].length; j++) {
                System.out.printf("   %-8d", salaryArr[i][j]);
                sum += salaryArr[i][j];
            }
            System.out.printf("   %-5d", sum);
            total += sum;
            sum = 0;
            System.out.println();
        }
        System.out.print("--------------------------------------------------------------");
        System.out.println();
        System.out.printf("Итого    %-8d%n", total);
        System.out.printf("Средняя  %-8.5f", (double) total / (namesArr.length * 4));
    }
}
