package by.it.zambrano.jd01_04;

import java.util.Scanner;

public class TaskA {
    static void printMultable() {
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 2, j, 2 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 3, j, 3 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 4, j, 4 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 5, j, 5 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 6, j, 6 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 7, j, 7 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 8, j, 8 * j);
        }
        System.out.println();
        for (int j = 2; j <= 9; j++) {
            System.out.printf("%1d*%1d=%-2d ", 9, j, 9 * j);
        }
        System.out.println();
    }


static void buildOneDimArray(String line){
    double[]array= InOut.getArray(line);
    double start=array[0];
    double stop=array[array.length-1];
    InOut.printArray(array,"V",5);
    Helper.sort(array);
    InOut.printArray(array,"V",4);
    for (int i = 0; i <array.length ; i++) {
        if(array[i]==start){
            System.out.println("Index of first element"+i);
            break;
        }
    }
    for (int i = 0; i <array.length; i++) {
        if(array[i]==stop){
            System.out.println("Index of last element"+i);
            break;
        }
    }

    }

    public static void main(String[] args) {
        printMultable();
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        buildOneDimArray(s);
    }
}