package by.it.okatov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y;
        double x = 2;
        for (double a = 0; a < 2; a += 0.2) {
            y = 0;
            for (x -= 1; x <= 6; x++) {
                y += (pow(7, a) - cos(x));
            }

            System.out.printf("При A=%5.2f Y=%-13e%n", a, y);
        }
    }

    private static void step2() {
        double alfa = 0;
        double beta = 0;

        for (double x = -6; x < 2; x += 0.5) {
            if ((x / 2 > -2) && (x / 2 <= -1)) {
                beta = sin(x * x);
                System.out.printf("x/2=%5.2f Alfa=%-13e при Beta=%5.2f%n", x / 2, alfa = log10(beta + 2.74), beta);
            } else if ((x / 2 > -1) && (x / 2 < 0.2)) {
                beta = cos(x * x);
                System.out.printf("x/2=%5.2f Alfa=%-13e при Beta=%5.2f%n", x / 2, alfa = log10(beta + 2.74), beta);
            } else if ((x / 2 == 0.2)) {
                beta = 1 / tan(x * x);
                System.out.printf("x/2=%5.2f Alfa=%-13e при Beta=%5.2f%n", x / 2, alfa = log10(beta + 2.74), beta);
            } else {
                System.out.printf("x/2=%5.2f %s%n", x / 2, "Вычисления не определены");
            }


        }
    }


}
