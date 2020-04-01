package by.it.verbitsky.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskA {
    public static void main(String[] args) throws IOException {
        printMulTable();
        String line = getLine();
        buildOneDimArray(line);
    }

    static  void printMulTable () {
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i,j,i*j);
            }
            System.out.println();
        }
    }

    static double[] getArray(String line) {
        line = line.trim();
        String[] stringDobles = line.split(" ");
        double[] arr = new double[stringDobles.length];
        for (int i = 0; i < stringDobles.length; i++) {
            if (!stringDobles[i].equals(" "))
                arr[i] = Double.parseDouble(stringDobles[i]);
        }
        return arr;
    }

    static String getLine() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        return buffer.readLine();
    }

    //
    static void buildOneDimArray(String line) {
        line = line.trim();
        String[] stringDobles = line.split(" ");
        double[] arr = new double[stringDobles.length];
        for (int i = 0; i < stringDobles.length; i++) {
            if (!stringDobles[i].equals(" "))
                arr[i] = Double.parseDouble(stringDobles[i]);
        }
        printArray(arr, "V", 5);
        double first = arr[0];
        double last = arr[arr.length-1];
        sort(arr);
        printArray(arr, "V", 4);
        int firstIndex = Arrays.binarySearch(arr, first);
        int lasttIndex = Arrays.binarySearch(arr, last);
        System.out.println("Index of first element="+firstIndex);
        System.out.println("Index of last element="+lasttIndex);
    }

    static void sort (double[] arr) {
        boolean isSorted = false;
        double buf;

        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
    }


    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[ %d ]=%-4.3f  ", name, i, arr[i]);
            if (i == columnCount - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }



}
