package by.it.tolstik.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] surNameArr = new String[n];
        for (int i = 0; i < surNameArr.length; i++) {
            surNameArr[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surNameArr[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        double sum = 0;
        double avg;
        for (int i = 0; i < surNameArr.length; i++) {
            System.out.print(surNameArr[i] + " ");
            for (int j = 0; j < 4; j++) {
                sum += salary[i][j];
                System.out.print(salary[i][j] + " ");
            }
            System.out.println();
        }
        avg = sum / (n * 4);
        System.out.printf("Итого %.2f", sum);
        System.out.println();
        System.out.printf("Средняя %.4f", avg);
    }
}
