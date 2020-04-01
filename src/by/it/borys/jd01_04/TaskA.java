package by.it.borys.jd01_04;



import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {

                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = getArray(line);
        printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        sort(array);
        System.out.println();
        printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }

    }

    private static void sort(double[] arr) {
        int i = 1;
        double temp;
        while (i < arr.length) {
            if (i == 0 || arr[i - 1] <= arr[i]) {
                i++;
            } else {
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;

            }
        }
        for (double elem : arr) {
            System.out.print(elem + " ");

        }
    }

    private static void printArray(double arr[], String name, int columnCount) {

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%4.2f  ", name, i + 1, arr[i]);
            if ((i + 1) % columnCount == 0 || i == (arr.length - 1)) {
                System.out.println();
            }
        }

    }

    private static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] arr = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            arr[i] = Double.parseDouble(strArray[i]);

        }
        return arr;
    }

}