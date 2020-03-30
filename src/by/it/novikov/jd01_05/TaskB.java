package by.it.novikov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        for(double a = 0; a <= 2.001; a += 0.2) {
            double sum = pow(7,a)*6;
            for(int k = 1; k <=6; ++k)
                sum -= cos(k);
            System.out.println(sum);
    }
}

}
