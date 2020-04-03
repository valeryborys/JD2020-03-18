package by.it.sinevich.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y=0;
        for(double a=0;a<=2;a+=0.2){
            for(double x=1;x<=6;x++){
                y += pow(7,a)-cos(x);

            }
            System.out.printf("При а =%6.2f f=%g\n", a,y);
        }
    }

    private static void step2() {
        double b;
        double a;
        for(double x=-5.5;x<2;x+=0.5){
            if(x/2>-2 || x/2<=-1){
                b=sin(x*x);
                //a=log(b+2.74);
                //System.out.printf("При x/2 =%6.2f a=%g\n", x/2,a);
            }

            else if(x/2>-1 || x/2<0.2){
                b=cos(x*x);
                //a=log(b+2.74);
                //System.out.printf("При x/2 =%6.2f a=%g\n", x/2,a);
            }
            else if(x/2==0.2){
                b=1/tan(x*x);
                //a=log(b+2.74);
                //System.out.printf("При x/2 =%6.2f a=%g\n", x/2,a);
            }
            else{
                b=0;
            }

             a=log(b+2.74);
            System.out.printf("При x/2 =%6.2f a=%g\n", x/2,a);
        }
    }
}
