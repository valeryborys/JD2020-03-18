package by.it.szamostyanin.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        System.out.println("Task B1");
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При A=%.1f Сумма Y=%f\n", a, y);
        }
        System.out.print("\n");
    }

    private static void step2() {
        System.out.println("Task B2");
        double b;
        double a;
        for (double x = -6; x < 2; x += 0.5) {
            if (-2 < x / 2 & x / 2 <= -1) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f A=%e\n", x / 2, a);
                continue;
            }

            if (-1 < x / 2 & x / 2 < 0.2) {
                b = cos(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f A=%e\n", x / 2, a);
                continue;
            }
            if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f A=%e\n", x / 2, a);
                continue;
            }
            if (-6 < x / 2) {
                System.out.printf("При x/2=%f Вычисления не определены\n", x / 2);
            }
        }
    }
}
