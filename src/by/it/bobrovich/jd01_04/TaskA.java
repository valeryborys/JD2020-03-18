package by.it.bobrovich.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    static double[] getArray(String line){
        String[] array = line.split(" ");
        double[] array1 = new double[array.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Double.parseDouble(array[i]);
        }
        return  array1;
    }

    static void printArray(double[] array, String name, int columnCount){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(count != columnCount){
                count += 1;
                System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            } else{
                count = 1;
                System.out.println();
                System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            }
        }
    }

    static void sort(double array[]){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min] > array[j]){
                    min = j;
                }
            }
            double tmp = array[i];
            array[i]=array[min];
            array[min] = tmp;
        }
    }

    private static void buildOneDimArray(String line) {
        double[] array = getArray(line);
        printArray(array,"V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        System.out.println();
        sort(array);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == first){
                System.out.println("Index of first element=" + i);
            } else if(array[i] == last){
                System.out.println("Index of last element=" + i);
            }
        }
        printArray(array,"V", 3);
    }
}
