package by.it.borys.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер месяца:");
        int month = sc.nextInt();
        System.out.println("Введите коэффициенты a b c квадратного уравнения:");
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step1();
        step2(month);
        step3(a, b, c);
    }

    private static void step2(int month) {
        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }


        }
    }

    private static void step1() {
        int[][] mas = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mas[i][j] = i * 5 + j + 1;
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void step3(double a, double b, double c) {
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println(x1 +" " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else System.out.println("корней нет");

    }
}
