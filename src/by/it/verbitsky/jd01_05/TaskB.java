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
            //System.out.println("\nX = " + x);
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
                continue;
            }

            if (x / 2. < -2) {
                System.out.printf("При значение х/2= %2.2f вычисления не определены\n", x / 2.);
            }

        }
        /*
         "При x/2=-1,75 a = 3,****62e-01\n" +
                "При x/2=-1,50 a = 4,****25e-01\n" +
                "При x/2=-1,25 a = 4,****95e-01\n" +
                "При x/2=-1,00 a = 2,****60e-01\n" +
                "При x/2=-0,75 a = 3,****82e-01\n" +
                "При x/2=-0,50 a = 5,****39e-01\n" +
                "При x/2=-0,25 a = 5,****66e-01\n" +
                "При x/2=0,00 a = 5,****16e-01\n" +
         */
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
