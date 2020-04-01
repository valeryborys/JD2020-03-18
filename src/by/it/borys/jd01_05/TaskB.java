package by.it.borys.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        double x = 0;
        step1(x);
        step2();
    }

    private static void step1(double x) {
        //double x = 0;
        double prom = 0;
        double y = 1;
        for (double a = 0; a <=2 ; a+=0.2) {
            for (double i = x - 1; x <= 6; x++) {
                prom += (pow(7, a) - cos(x));
            }
                y*=prom;
            System.out.printf("При a = %4.2f сумма y = %g\n",a,y);
        }
    }

    private static void step2() {
           for (double x = -5.5; x <2 ; x+=0.5) {
               double m = x/2;
           if (m > -2 && m<=-1){
               double a = log10(abs(sin(pow(x,2))+2.74));
               System.out.printf("При x/2 = %4.2f    a = %g\n",m,a);
           }
           else if (m>-1 && m<0.2){
               double a = log10(abs(cos(pow(x,2))+2.74));
               System.out.printf("При x/2 = %4.2f    a = %g\n",m,a);
           }
            else System.out.printf("При x/2 = %4.2f %s\n",m,"вычисления не определены");
        }

    }
}
