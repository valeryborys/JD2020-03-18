package by.it.okatov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите кол-во людей в списке: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        String[] names = new String[n];
        System.out.println("Введите их фамилии: ");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }
        int[][] salary = new int[n][4];

        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("Введите зарплату %sа за %s квартал: ", names[i], j);
                salary[i][j] = sc.nextInt();
            }
        }

        printTable(salary, names);
    }


    static void printTable(int[][] salaries, String[] names) {
        int sum = 0;
        int common = 0;
        System.out.printf("_______________________________________________________________________%n");
        System.out.printf("%-12s | %9s | %9s | %9s | %9s | %7s |%n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.printf("_______________________________________________________________________%n");
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("%-12s |", names[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                System.out.printf(" %9d |", salaries[i][j]);
                sum += salaries[i][j];
                common += salaries[i][j];
            }
            System.out.printf(" %7d| ", sum);
            sum = 0;
            System.out.println();
        }
        double avg = (double) common / (salaries.length * salaries[0].length);
        System.out.println("_______________________________________________________________________");
        System.out.printf("%-12s %-9d %n%-12s %-9.04f", "Итого", common, "Средняя", avg);
    }
}
