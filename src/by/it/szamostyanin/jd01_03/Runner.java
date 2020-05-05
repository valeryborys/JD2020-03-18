package by.it.szamostyanin.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] strArr = InOut.getArray(str);
        InOut.printArray(strArr);
        InOut.printArray(strArr, "M", 2);
        System.out.println("Min=" + Helper.findMin(strArr));
        System.out.println("Max=" + Helper.findMax(strArr));

        double [] vector = new double[] {1,2,3};
        double [][] matrix = new double[][] {{1,2,3},{4,5,6}};
        double [][] matrixL = new double[][] {{1,2,3,4},{5,6,7,8}};
        double [][] matrixR = new double[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Matrix * Vector = "+ Arrays.toString(Helper.mul(matrix, vector)));
        System.out.println("MatrixL * MatrixR = "+ Arrays.deepToString(Helper.mul(matrixL, matrixR)));
        Helper.sort(strArr);
        System.out.println(Arrays.toString(strArr));
    }
}
