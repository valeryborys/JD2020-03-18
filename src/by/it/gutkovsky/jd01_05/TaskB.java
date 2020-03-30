package by.it.gutkovsky.jd01_05;



import static java.lang.Math.*;

 class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
        
    }

    private static void step1() {
        int x = 1;
        double y = 0;
        for (double a = 0; a <=2; a+=0.2) {
            for (int x1 = x; x1 <= 6; x1++) {
                double y1 = (pow(7,a) - cos(x1));
                y =y+y1;
            }
            System.out.printf("%6s%3.2f %9s%-13e\n","При a=",a, "Сумма y =", y);
        }
        System.out.println();

    }

    private static void step2() {
        for (double x = -5.5; x <=2 ; x+=0.5) {
            if (x/2 > -2 && x/2<=-1 ){
                double b = sin(x*x);
                double a = log10(Math.abs((b+2.74)));
                System.out.printf("%-7s%3.2f %4s%-13e\n", "при x/2=",x/2, "a = ", a);
            } else if (x/2 > -1 && x/2 < 0.2) {
                double b = cos(x*x);
                double a = log10(Math.abs((b+2.74)));
                System.out.printf("%-7s%3.2f %4s%-13e\n", "при x/2=",x/2, "a = ", a);
            } else if (x/2 == 0.2) {
                double b = cos(x*x) / sin(x*x);
                double a = log10(Math.abs((b+2.74)));
                System.out.printf("%-7s%3.2f %4s%-13e\n", "при x/2=",x/2, "a = ", a);
            } else {
                System.out.printf("%-6s%3.2f %24s\n","при х/2=",x/2, "вычисления не определены");
            }

        }

    }

}
