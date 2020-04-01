package by.it.zambrano.jd01_04;
import java.util.Scanner;
public class TaskB {

    public static void main(String[] args) {
        System.out.println("nro persons ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        String[] surnames = new String[n];
        System.out.println("insert surnames ");
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = sc.next();
        }
        int[][] salary = new int[n][4];

        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("Введите зарплату %s | %s квартал: ", surnames[i], j);
                salary[i][j] = sc.nextInt();
            }
        }

        printTable(salary, surnames);
    }

    private static void printTable(int[][] salary, String[] surnames) {
        int sum = 0;
        int newsum = 0;
        System.out.printf("--------------------------------------------------------------\n");
        System.out.printf("\"%-14s | %10s | %10s | %10s | %10s | %10s |%n\"\"Фамилия\" \"Квартал 1\" \"Квартал 2\" \"Квартал 3\" \"Квартал 4\" \"Итого\"");
        System.out.printf("--------------------------------------------------------------\n");
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%-12s |", surnames[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf(" %9d |", salary[i][j]);
                sum += salary[i][j];
                newsum += salary[i][j];
            }
            System.out.printf(" %10d| ", sum);
            sum = 0;
            System.out.println();
        }
        double avg = (double) newsum / (salary.length * salary[0].length);
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-12s %-9d %n%-12s %-9.04f", "Итого", newsum, "Средняя", avg);
    }


}
