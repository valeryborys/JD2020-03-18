package by.it.tolstik.jd01_05;

import static java.lang.Math.*;

class TaskC {
    public static void main(String[] args) {
        double[] a = new double[40];
        double[] temp = new double[40];
        int i = 0;
        for (double x = 5.33; x <= 9; x += 0.09) {

            if (i >= 40) {
                break;
            } else {
                a[i] = pow(pow(x, 2) + 4.5, 1. / 3);
                i++;
            }
        }
        for (int j = 0; j < a.length; j++) {
            System.out.printf("%s[%2d]=%10.5f ", "A", j, a[j]);
            if ((j + 1) % 5 == 0 || i + 1 == a.length) {
                System.out.println();
            }
        }
        int count = 0;
        for (int k = 0, k1 = 0; k < a.length; k++) {
            if (a[k] >= 3.5) {
                temp[k1] = a[k];
                k1++;
                count++;
            }
        }
        System.out.println();
        double[] b = new double[count];
        for (int m = 0; m < b.length; m++) {
            b[m] = temp[m];
            System.out.printf("%s[%2d]=%10.5f ", "B", m, b[m]);
            if ((m + 1) % 5 == 0 || i + 1 == a.length) {
                System.out.println();
            }
        }
    }
}
