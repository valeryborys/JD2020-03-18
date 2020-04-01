package by.it.bobrovich.jd01_04;


import java.util.Scanner;

public class TaskB {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] surname = getSurname(n);
        int[][] salary = getSalary(n, surname);
        printValue(surname, salary);
    }

    private static String[] getSurname(int n) {
        String[] surname = new String[n];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = scanner.next();
        }
        return surname;
    }

    private static int[][] getSalary(int n, String[] surname) {
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        return salary;
    }

    private static void printValue(String[] surname, int[][] salary) {
        int sum = 0;
        int allSum = 0;
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%-8s:",surname[i]);
            for (int j = 0; j < 4; j++) {
                sum += salary[i][j];
                System.out.printf("%-10d",salary[i][j]);
            }
            System.out.printf("%-9d\n",sum);
            allSum += sum;
            sum = 0;
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-9d\n","Итого", allSum);
        System.out.printf("%-10s%-9.4f","Средняя", allSum/(surname.length*4.));
    }
}
