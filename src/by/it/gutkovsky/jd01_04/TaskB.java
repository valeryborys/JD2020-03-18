package by.it.gutkovsky.jd01_04;

import jdk.nashorn.internal.ir.CallNode;

import java.util.Scanner;

 class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arrayOfNames = new String[n];
        for (int i = 0; i < arrayOfNames.length; i++) {
            arrayOfNames[i] = sc.next();
        }
        // array for salary
        int[][] salaryArray = new int[n][4];

        for (int i = 0; i < salaryArray.length; i++) {
            System.out.println("Введите зарплату для " + arrayOfNames[i]);
            for (int j = 0; j < salaryArray[0].length; j++) {
                salaryArray[i][j] = sc.nextInt();
            }
        }

//        for (int i = 0; i < salaryArray.length; i++) {
//            for (int j = 0; j < salaryArray[0].length; j++) {
//                System.out.print(salaryArray[i][j] + " ");
//            }
//            System.out.println();
//        }
        printSalaryTable(arrayOfNames, salaryArray);




    }
    static void printSalaryTable(String[] arrayOfNames, int[][] salaryArray){
        int sumByPerson = 0;
        int total = 0;
        int quantity = 0;
        double average = 0.0;
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < salaryArray.length; i++) {
            System.out.printf("%-15s", arrayOfNames[i]);
            for (int j = 0; j < salaryArray[0].length; j++) {
                System.out.printf("%-10d", salaryArray[i][j]);
                sumByPerson = sumByPerson + salaryArray[i][j];
                total += salaryArray[i][j];
                quantity++;
            }
            System.out.printf("%-10d", sumByPerson);
            sumByPerson = 0;
            System.out.println();
        }

        average = (double) total / quantity;

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-15s%-10d%n","Итого", total);
        System.out.printf("%-15s%-11.4f", "Средняя", average);



    }
}
