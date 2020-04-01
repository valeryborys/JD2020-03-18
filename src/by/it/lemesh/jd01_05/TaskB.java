package by.it.lemesh.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a < 2.1; a += 0.2) {
            for (int j = 0; j < 7; j++) {
                y = y + pow(7, a) - cos(j);
            }
            System.out.printf("При a=%4.2f Сумма y = %g%n", a, y);
            y = 0;
        }
    }

    private static void step2() {
        double a, b;
        for (double x = -5.5; x < 2; x += 0.5) {
            if ((x / 2 > -2) & (x / 2 <= -1)) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%5.2f a = %f%n", x / 2, a);
            } else if ((x / 2 > -1) & (x / 2 < 0.2)) {
                b = cos(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%5.2f a = %f%n", x / 2, a);
            } else if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%5.2f a = %f%n", x / 2, a);
            } else
                System.out.printf("При x/2=%5.2f вычисления не определены%n", x / 2);
        }
    }
}
