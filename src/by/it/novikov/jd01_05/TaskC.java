package by.it.novikov.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        task6();
        task7();
        int[] arrayA = createArray31();
        int[] arrayB = createArrayB(arrayA);
        printArray(arrayA);
        printArray(arrayB);
        printTableA(arrayA, 3);
        printTableB(arrayB, 2);
    }

    private static void printTableA(int[] arrayA, int cols) {
        System.out.println("Array A - index to rows");
        int rows = (arrayA.length % cols > 0) ? arrayA.length / cols + 1 : arrayA.length / cols;
        int count = 0;
        for (int r = 0; r <= rows * 2 - 1; r++) { //заполняем строки
            if (r == 0) {   //первая строка ╔ ═ ╦ ╗
                System.out.print("╔");
                for (int c = 0; c < cols - 1; c++) {
                    System.out.print("═══════════╦");
                }
                System.out.println("═══════════╗");
            }
            if (r % 2 == 1) { //второй ряд заполняем вертикали ║ ряды с нечет номерами

                for (int c = 0; c < cols; c++) {
                    System.out.printf("║ %s[%-2d]=%-3d ", "A", count, arrayA[count++]);
                    if (count == arrayA.length) {
                        break;
                    }
                }
                if (count < arrayA.length) {
                    System.out.println("║");

                }
            }
            if (r % 2 == 0) { // ╠  ╬
                System.out.print("╠");
                for (int c = 0; c < cols - 1; c++) {
                    System.out.print("═══════════╬");
                }
                System.out.println("═══════════╣");
            }
        }
        if (arrayA.length % cols > 0) {
            for (int i = 0; i < cols - arrayA.length % cols; i++) {
                System.out.print("║           ");
            }
            System.out.println("║");
        }
        System.out.print("╚");
        for (int c = 0; c < cols - 1; c++) {
            System.out.print("═══════════╩");
        }
        System.out.println("═══════════╝");
    }

    private static void printTableB(int[] arrayB, int cols) {
        System.out.println("Array B - index to cols");
        int rows = (arrayB.length % cols > 0) ? arrayB.length / cols + 1 : arrayB.length / cols;
        int counter = 0;
        for (int r = 0; r < rows * 2; r++) {
            if (r == 0) {
                System.out.print("╔");
                for (int c = 0; c < cols - 1; c++) {
                    System.out.print("═══════════╦");
                }
                System.out.println("═══════════╗");
            } else if (r % 2 == 1) {
                for (int c = 0; c < cols; c++) {
                    int i = counter + rows * c;
                    if (i < arrayB.length) {
                        System.out.printf("║ %s[%-2d]=%-3d ", "B", i, arrayB[i]);
                    } else {
                        System.out.print("║           ");
                    }
                }
                System.out.println("║");
                counter++;

            } else {
                System.out.print("╠");
                for (int c = 0; c < cols - 1; c++) {
                    System.out.print("═══════════╬");
                }
                System.out.println("═══════════╣");
            }
        }
        System.out.print("╚");
        for (int c = 0; c < cols - 1; c++) {
            System.out.print("═══════════╩");
        }
        System.out.println("═══════════╝");
    }

    private static void task6() {
        double[] array = createArrayFrom20To40();
        fillArray(array);
        double mean = geometricMean(array);
        System.out.println("Mean = " + mean);
    }

    private static double[] createArrayFrom20To40() {
        int n = (int) (random() * 21) + 20;
        return new double[n];
    }

    private static void fillArray(double[] array) {
        double deltaX = (9 - 5.33) / (array.length);
        System.out.println("array length = " + array.length);
        System.out.println("delta x = " + deltaX);
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            array[i] = cbrt(x * x + 4.5);
            x += deltaX;
        }
        printArray(array, "V", 4);
    }

    private static double geometricMean(double[] array) {
        int countOfMoreThen3point5 = 0;
        for (double a : array) {
            if (a > 3.5) {
                countOfMoreThen3point5++;
            }
        }
        double[] arrayMoreThen3point5 = new double[countOfMoreThen3point5];
        int count = 0;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                arrayMoreThen3point5[count] = array[i];
                sum += arrayMoreThen3point5[count++];
            }
        }
        double mean = sum / countOfMoreThen3point5;
        printArray(arrayMoreThen3point5, "V", 4);

        return mean;
    }

    private static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[ %-2d] = %-8.6f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void task7() {

    }

    private static int[] createArray31() {
        int[] array = new int[31];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random() * 348) + 103;
        }

        return array;
    }

    private static int[] createArrayB(int[] arrayA) {
        int countOfMembersInB = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] / 10 > i) {
                countOfMembersInB++;
            }
        }
        int[] arrayB = new int[countOfMembersInB];
        int counter = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] / 10 > i) {
                arrayB[counter++] = arrayA[i];
            }
        }
        Arrays.sort(arrayB);
        return arrayB;
    }
}