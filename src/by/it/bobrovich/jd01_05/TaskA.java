package by.it.bobrovich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        double a = 756.13;
        double x = 0.3;
        double z = pow(cos(pow(x,2)+PI/6.), 5) - sqrt(x*pow(a, 3))-log(abs((a-1.12*x)/4));
        System.out.println(z);
    }
}
