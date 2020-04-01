package by.it.verbitsky.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        System.out.println("\n задание Б");
        double b;
        double a;
        for (double x = -6; x < 2; x += 0.5) {
            if ((-2 < x / 2.) & (x / 2. <= -1)) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При значение х/2= %2.2f a = %e\n", x / 2., a);
                continue;
            }
            if ((-1 < x / 2.) & (x / 2. < 0.2)) {
                b = cos(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("При значение х/2= %2.2f a = %e\n", x / 2., a);
                continue;
            }
            if (x / 2.== 0.2) {
                b = cos(x * x) / sin(x*x);
                a = log10(abs(b + 2.74));
                System.out.printf("При значение х/2= %2.2f a = %e\n", x / 2., a);
                continue;
            }
            if (x / 2. > -6) {
                System.out.printf("При значение х/2= %2.2f вычисления не определены\n", x / 2.);
            }

           /* if (x / 2. < 2) {
                System.out.printf("При значение х/2= %2.2f вычисления не определены\n", x / 2.);
            }*/
        }
    }

    private static void step1() {
        System.out.println("\n задание A");
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x < 7; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При а = %f y = %e\n", a, y);
        }
    }
}
