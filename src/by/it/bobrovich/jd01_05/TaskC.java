package by.it.bobrovich.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        int i = (int) (random() * 20 + 20);
        double array[] = new double[i];
        int j = 0;

        int count1 = 0;

        for (double x = 5.33; x < 9; x += 0.1) {
            if (j < array.length) {
                array[j] = pow(x * x + 4.5, 1 / 3.);
                if (array[j] > 3.5) count1 += 1;
                j++;
            } else {
                break;
            }
        }
        System.out.println("Массив А[]");
        printArray(array, "A");
        System.out.print("\n\n");
        printNewArray(array, count1);
    }

    private static void printArray(double[] array, String name) {
        int count = 0;
        int columnCount = 5;
        for (int i = 0; i < array.length; i++) {
            if (count != columnCount) {
                count += 1;
                System.out.printf("%s[% -3d]=%-10.5f ", name, i, array[i]);
            } else {
                count = 1;
                System.out.println();
                System.out.printf("%s[% -3d]=%-10.5f ", name, i, array[i]);
            }
        }
    }

    private static void printNewArray(double[] array, int count) {
        double array1[] = new double[count];
        for (int i = 0, j = 0; i < array.length; i++) {
            if(array[i] > 3.5){
                array1[j] = array[i];
                j++;
            }
        }
        System.out.println("Массив B[] из элементов A[]");
        printArray(array1, "B");
    }
}

