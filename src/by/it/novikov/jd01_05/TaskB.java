package by.it.novikov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step2() {
        double af;

        double bt;

        for (double x = -6; x < 2; x = x + 0.5) {
            if (((x / 2) > -2) & ((x / 2) <= -1)) {
                bt = sin(x * x);
                af = log10(abs(bt + 2.74));
                System.out.printf("При значении x/2= %2.2f a = %e %n", x / 2, af);
                continue;
            }
            if ((((x / 2) > -1) & ((x / 2) < 0.2))) {
                bt = cos(x * x);
                af = log10(abs(bt + 2.74));
                System.out.printf("При значении x/2= %2.2f a = %e %n", x / 2, af);
                continue;
            }
            if (x / 2 == 0.2) {
                bt = cos(x * x) / sin(x * x);
                af = log10(abs(bt + 2.74));
                System.out.printf("При значении x/2= %2.2f a = %e %n", x / 2, af);
                continue;
            }
            if (x / 2 > -6) {
                System.out.printf("При значение х/2= %2.2f вычисления не определены%n", x / 2.);
            }


        }
    }


    private static void step1() {
        for(double a = 0; a <= 2.001; a =a+ 0.2) {
            double sum = pow(7,a)*6;
            for(int j = 1; j <=6; ++j)
                sum=sum- cos(j);
            System.out.println(sum);
    }
}



}
