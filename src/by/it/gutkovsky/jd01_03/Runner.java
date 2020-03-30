package by.it.gutkovsky.jd01_03;

import java.util.Scanner;

 class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
//        String line = "1 2.3 15 6 5.5 15 75 8 9 10";
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "element", 2);
        double min = Helper.findMin(array);
        System.out.printf("%s%-8.2f\n", "The minimum is ", min);
        double max = Helper.findMax(array);
        System.out.printf("%s%-8.2f\n", "The maximum is ", max);
        Helper.sort(array);

        double[][] matrix = {{2, 3}, {3, 5}};
        double[] vector = {2, 2};
        InOut.printArray(Helper.mul(matrix, vector));

        double[][] matrix2 = {{1, 2}, {4, 5}};
        double[][] matrix3 = {{1, 2}, {3, 4}};

        InOut.printMatrix(Helper.mul(matrix2, matrix3));
//        InOut.printMatrix(matrix);



    }
}
