package by.it.tolstik.jd01_05;

import static java.lang.Math.*;

class TaskB {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        double sum = 0;
        double y = 0;
        for (double a = 0; a <=2 ; a+=0.2) {
            for (int x = 1; x <= 6; x++) {
                y = pow(7, a) - cos(x);
                System.out.printf("При a=%.1f и при х=%d y=%.1f \n",a,x,y);
                sum+=y;
            }
            System.out.println(sum);
            y = 0;
        }

        System.out.println("2756");
    }
    private static void task2() {
        double a = 0;
        for (double x = -6; x < 2; x+=0.5) {
            if (x/2 > -2 & x/2 <= -1) {
                a = log(abs(sin(pow(x,2))+2.74));
            }
            if (x/2 > -1 & x/2 < 0.2) {
                a = log(abs(cos(pow(x,2))+2.74));
            }
            if (x/2 == 0.2) {
                a = log(abs(1/(tan(pow(x,2)))+2.74));
            }
            if (a == 0) {
                System.out.printf("При х/2=%.2f = значения не определены \n",x/2);
                a = 0;
            }
            else {
                System.out.printf("При х/2=%.2f = %.3f \n",x/2,a);
                a = 0;
            }
        }
        System.out.println("8540");
    }

}
