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
        Helper.sort(strArr);
        System.out.println(Arrays.toString(strArr));
    }
}
