package by.it.gutkovsky.jd01_05;

import static java.lang.Math.*;

 class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;

        double part1 = cos(pow((x * x + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.25 * x) / 4));

        double z = part1 - part2 - part3;
        System.out.printf("TaskA1\na=%f x=%f z=%5f\n", a, x, z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;

        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1. / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.printf("TaskA2\nA =%f B=%f Z =%5f\n", a, b, y);
    }

    private static void step3() {
        System.out.println("TaskA3");
        double x = 12.1;
        System.out.printf("%-6s %-2s\n", "при a=", "f=");
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("%5.2f %-13e\n", a, f);
        }
    }
}
