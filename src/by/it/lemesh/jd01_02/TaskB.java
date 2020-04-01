package by.it.lemesh.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        step1();
        System.out.println("Введите номер месяца:");
        int month = sc.nextInt();
        step2(month);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step3(a, b, c);
    }

    private static void step1() {
        for (int i = 1; i < 26; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0)
                System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }
    }

    private static void step3(double a, double b, double c) {
        double x1, x2, d;
        d = b * b - 4 * a * c;
        if (d < 0)
            System.out.println("корней нет");
        if (d == 0) {
            x1 = -(b / (2 * a));
            System.out.println(x1);
        }
        if (d > 0) {
            x1 = (Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
            x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}
