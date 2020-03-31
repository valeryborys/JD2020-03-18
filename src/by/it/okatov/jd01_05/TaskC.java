package by.it.okatov.jd01_05;

import java.util.Arrays;

import static java.lang.Math.ceil;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        int n = (int) ceil((9 - 5.33) / 0.1);
        int count = 0;

        double[] zArray = new double[n];
        int j = 0;

        for (double x = 5.33; x <= 9; x += 0.1) {
            zArray[j] = (pow((x * x + 4.5), 1. / 3));
            j++;
        }

        System.out.println("Массив А: ");
        printArrayWithoutFormatting(zArray, "А", 5);

        for (double z : zArray) {
            if (z >= 3.5) {
                count++;
            }
        }

        double[] secondArray = new double[count];
        j = 0;
        for (double z : zArray) {
            if (z >= 3.5) {
                secondArray[j] = z;
                j++;
            }
        }

        System.out.println("Массив Б: ");
        printArrayWithoutFormatting(secondArray, "Б", 5);
    }

    static void printArrayWithoutFormatting(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-3d] = %-8.5f ", name, i, arr[i]);

            if ((i + 1) % columnCount == 0 || i == (arr.length - 1)) {
                System.out.println();
            }
        }

        //System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        System.out.printf("╔");
        for (int i = 0; i < columnCount; i++) {

            if ((i + 1) % columnCount == 0) {
                System.out.printf("═════════════╗%n");
            } else {
                System.out.printf("═════════════╦");
            }
        }
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("║%s[%-3d]=%-5.1f ", name, i, arr[i]);

            if ((i + 1) % columnCount == 0 && i != (arr.length - 1)) {
                System.out.printf("║%n╠");
                //System.out.println("");
                //System.out.printf("╠");
                for (int j = 0; j < columnCount; j++) {

                    if ((j + 1) % columnCount == 0) {
                        System.out.printf("═════════════╣");
                    } else {
                        System.out.printf("═════════════╬");
                    }
                }
                System.out.println();
            }

            if (i == (arr.length - 1)) {
                System.out.printf("║%n╚");
                for (int j = 0; j < columnCount; j++) {

                    if ((j + 1) % columnCount == 0) {
                        System.out.printf("═════════════╝");
                    } else {
                        System.out.printf("═════════════╩");
                    }
                }
            }
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name) {
        System.out.printf("%s%n", "╔══════════════╦═════════════╗");
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.printf("║%s[%-3d]=%-7.1f║ %s[%-3d]=%-5.1f║%n", name, i, arr[i], name, arr.length / 2 + i, arr[arr.length / 2 + i]);

            if (i == (arr.length / 2 - 1)) {
                System.out.printf("%s%n", "╚══════════════╩═════════════╝");
            } else {
                System.out.printf("╠══════════════╬═════════════╣%n");
            }
        }
        System.out.println();
    }

    private static void step2() {
        double[] Arr = new double[30];
        Arr = generate(Arr);

        int count = 0;
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] * 0.1 > i) {
                count++;
            }
        }

        double[] secondArr = new double[count];
        int j = 0;
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] * 0.1 > i) {
                secondArr[j] = Arr[i];
                j++;
            }
        }

        System.out.println("\n\nArray A:");
        printArray(Arr, "A", 5);
        System.out.println("\nArray B:");
        Arrays.sort(secondArr);
        printArray(secondArr, "B");
    }

    private static double[] generate(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (450 - 103)) + 103;
        }

        return arr;
    }
}
