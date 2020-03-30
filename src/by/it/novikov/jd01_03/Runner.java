package by.it.novikov.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "S", 2);
        System.out.println();
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        System.out.println();
        Helper.sort(array);


    }

    }




