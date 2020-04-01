package by.it.bobrovich.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double matrix[][] = {{1, 2, 3},{4, 5, 6}};
        double matrix1[][] = {{1, 2, 3},{4, 5, 6}};
        double vector[] = {1, 2, 3};
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double array[] = InOut.getArray(line);
        InOut.printArray(array);
        System.out.println();
        InOut.printArray(array, "mas", 5);
        System.out.println(Helper.findMin(array) + " " + Helper.findMax(array));
        Helper.sort(array);
        InOut.printArray(array);
        InOut.printArray(Helper.mul(matrix, vector));
        System.out.println();
        double newMatrix[][] = Helper.mul(matrix, matrix1);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
