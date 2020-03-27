package by.it.tolstik.jd01_03;

import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.nextLine();
        double[] array = InOut.getArray(arr);
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);
        InOut.printArray(array, "A", 3);
        double[][] arr1 = new double[][]{{1, 2, 3}, {1, 2, 3}};
        double[][] arr2 = new double[][]{{1, 2}, {1, 2}, {1, 2}};
        double[] arr3 = new double[]{1, 2};


    }
}
