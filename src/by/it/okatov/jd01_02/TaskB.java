package by.it.okatov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        step1();
        int month;
        System.out.println("\n\nВведите номер месяца: ");
        month = sc.nextInt();
        step2(month);
        double a, b, c;
        System.out.println("\n\nВведите a: ");
        a = sc.nextDouble();
        System.out.println("Введите b: ");
        b = sc.nextDouble();
        System.out.println("Введите c: ");
        c = sc.nextDouble();
        step3(a, b, c);
    }

    public static void step1() {
        for (int i = 1; i <= 25; i++) {
            if ((i - 1) % 5 == 0) {
                System.out.println();
            }
            System.out.print(i + " ");
        }
    }

    public static void step2(int month) {
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

    public static void step3(double a, double b, double c) {
        System.out.println(String.format("\n\nКвадратное уравнение вида: (%s*x^2) + (%s*x) + (%s) = 0", a, b, c));
        double D = (b * b) - (4 * a * c);
        if ((D < 0) || (b == 0 && a == 0) || (a == 0)) {
            System.out.println(String.format("Дискриминант D = %s, корней нет", D)); //no roots (only complex)
        } else {
            System.out.println(String.format("Дискриминант D = %s", D));

            if (D == 0) {
                double x1 = (-b) / (2 * a);
                System.out.println(String.format("\nКорень x1 = %s", x1));
            } else {
                double x1 = ((-b) + Math.sqrt(D)) / (2 * a);
                double x2 = ((-b) - Math.sqrt(D)) / (2 * a);
                System.out.println(String.format("\nКорень x1 = %s, Корень x2 = %s", x1, x2));
            }

        }
    }
}
