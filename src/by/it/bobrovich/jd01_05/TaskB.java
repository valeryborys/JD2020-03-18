package by.it.bobrovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 1;
        for (double i = 0; i < 2.2; i += 0.2) {
            for (int x = 0; x < 7; x++) {
                y = y + pow(7, i) - cos(x);
            }
            System.out.printf("При а=%-6.2f Сумма y = %g\n", i, y);
            y = 0;
        }
    }

    private static void step2() {
        double a = 0;
        for (double i = -5.5; i < 2; i += 0.5) {
            double x = i / 2;
            if (x > -2 && x <= -1){
                a = abs(log10(sin(i*i)+2.74));
                System.out.println("При x =" + x + " a = " + a);
            }else if(x > -1 && x < 0.2){
                a = abs(log10(cos(i*i)+2.74));
                System.out.println("При x =" + x + " a = " + a);
            }else if(x == 0.2){
                a = abs(log10((1/tan(i*i))+2.74));
                System.out.println("При x =" + x + " a = " + a);
            }else{
                System.out.println("При x =" + x + " a неизвестно ");
            }
        }
    }
}
