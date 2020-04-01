package by.it.verbitsky.jd01_03;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        double[] mas = InOut.getArray(InOut.getLine());
        System.out.println(Helper.findMin(mas));
        System.out.println(Helper.findMax(mas));
        Helper.sort(mas);
        InOut.printArray(mas);

        double [] vector = new double[] {2,2,2};
        double [][] matrix = new double[][] {{1,2,3},{4,5,6},{7,8,9}};
        double [] resVect = Helper.mul(matrix, vector);


        double [][] matrixL = new double[][] {{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        double [][] matrixR = new double[][] {{2,2,2},{2,2,2},{2,2,2}, {2,2,2,2}};
        double [][] array = Helper.mul(matrixL, matrixR);
        //Arrays.deepToString(array);

    }
}
