package by.it.szamostyanin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of people: ");
        int n = sc.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");
            name[i] = sc.next();
        }
        //заполняем массив данными
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Salary for " + name[i] + ": ");
                salary[i][j] = sc.nextInt();
            }
        }

        //выводим на консоль
        for (int i = 0; i < n; i++) {
            System.out.print(name[i] + ": ");
            for (int j = 0; j < 4; j++) {
                System.out.print(salary[i][j] + " ");
            }
            System.out.print("\n");
        }

        //находим сумму
        int sumAll = 0;
        int[] avrSalary = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += salary[i][j];    //сумма на 1 человека
            }
            System.out.print("Sum " + name[i] + ": " + sum + "\n");
            avrSalary[i] = sum; //записываем
            sumAll += sum;    //находим сумму всех
        }
        System.out.println("Sum all: " + sumAll);

        //находим среднее арифметическое
        double avrSalary2 = 0;
        for (int i = 0; i < n; i++) {
            avrSalary2 += (double) avrSalary[i] / 4;
        }
        System.out.printf("Average %3.4f", avrSalary2 / n);
    }
}
