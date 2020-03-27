package by.it.okatov.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    static void step1() {
        double a = 756.13;
        double x = 0.3;

        double z;
        double part1 = cos(pow((x * x + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));

        z = part1 - part2 - part3;

        System.out.printf("Task1:%nA=%f X=%f z=%f%n", a, x, z);
    }

    static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan((a + b) * (a + b)) - pow(a + 1.5, 1. / 3) + a * pow(b, 5) - b / log(a * a);

        System.out.printf("Task2:%nA=%f B=%f y=%f%n", a, b, y);
    }

    static void step3() {
        double x = 12.1;
        double f;
        System.out.printf("Task3:%n    A        F%n");
        for (double a = -5; a <= 12; a += 3.75) {
            f = exp(a * x) - 3.45 * a;
            System.out.printf("При а =%5.2f f=%-13e%n", a, f);
        }
    }
}
