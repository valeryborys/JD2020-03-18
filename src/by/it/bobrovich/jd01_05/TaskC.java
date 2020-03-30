package by.it.bobrovich.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        System.out.println();
        step2();
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

    private static void step2() {
        int array[] = new int[31];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random() * (450 - 103) + 103);
            if (array[i] / 10 > i) count += 1;
        }
        printArray(array, "A");
        newArray(array, count);
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

    private static void printArray(int[] array, String name) {
        int count = 0;
        int columnCount = 5;
        short col = 9553;
        printUp();
        for (int i = 0; i < array.length; i++) {
            if (count != columnCount) {
                count += 1;
                System.out.printf("%c%2s[% -3d]=%-3d ",col, name, i, array[i]);
            } else {
                count = 1;
                System.out.printf("%c", col);
                System.out.println();
                printMid();
                System.out.printf("%c%2s[% -3d]=%-3d ",col, name, i, array[i]);
            }
        }
        System.out.println();
        printDown();
    }

    private static void printDown() {
        short row = 9552;
        short leftDownAngle = 9562;
        short rightDownAngle = 9565;
        short down = 9577;
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c", leftDownAngle, row, row, row, row, row, row, row, row, row, row, row, row, down);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, down);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, down);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, down);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c\n", row, row, row, row, row, row, row, row, row, row, row, row, rightDownAngle);
    }

    private static void printMid() {
        short row = 9552;
        short left = 9568;
        short right = 9571;
        short cross = 9580;
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c", left, row, row, row, row, row, row, row, row, row, row, row, row, cross);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, cross);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, cross);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, cross);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c\n", row, row, row, row, row, row, row, row, row, row, row, row, right);
    }

    private static void printUp() {
        short row = 9552;
        short leftUpAngle = 9556;
        short up = 9574;
        short rightUpAngle = 9559;
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c", leftUpAngle, row, row, row, row, row, row, row, row, row, row, row, row, up);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, up);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, up);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c", row, row, row, row, row, row, row, row, row, row, row, row, up);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%c%c%c\n", row, row, row, row, row, row, row, row, row, row, row, row, rightUpAngle);
    }

    private static void printNewArray(double[] array, int count) {
        double array1[] = new double[count];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                array1[j] = array[i];
                j++;
            }
        }
        System.out.println("Массив B[] из элементов A[]");
        printArray(array1, "B");
    }

    private static void newArray(int[] array, int count) {
        int array1[] = new int[count];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] / 10 > i) {
                array1[j] = array[i];
                j++;
            }
        }
        Arrays.sort(array1);
        System.out.println();
        printArray(array1, "B");
    }
}

