
package by.it.borys.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа массива:");
        String line = sc.nextLine();
        System.out.println("Введите имя массива:");
        String name = sc.nextLine();
        System.out.println("Введите количество столбцов:");
        int columnCount = sc.nextInt();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr, name, columnCount);
        System.out.println(Helper.findMin(arr));
        System.out.println(Helper.findMax(arr));
        Helper.sort(arr);
        double[][] matrix = new double[][]{{1,2,4.5},{1,8,4.4},{1,4,5},{8.89,8,2} };
        double[] vector = new double[]{1,2,4};
        Helper.mul(matrix, vector);
        double[][] matrixLeft= new double[][]{{1,2,3},{2,2.3,4.5},{5,8,9}};
        double[][] matrixRight= new double[][]{{1,5,5},{3.2,5,2},{1,4,1}};
        Helper.mul(matrixLeft, matrixRight);
    }
}
