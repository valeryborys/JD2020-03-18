package by.it.zambrano.jd01_03;

import java.util.Arrays;

public class Helper {

    static double findMin(double[] arr) {
        double min=arr[0];
        for (int element = 0; element < arr.length; element++) {
            if (min > arr[element]) {
                min = (double) arr[element];
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max=arr[0];
        for (int element = 0; element < arr.length; element++) {
            if (max < arr[element]) {
                max = (double) arr[element];
            }
        }
        return max;
    }



    static void sort(double[ ] arr){
        InOut.printArray(arr);
        for(double element:arr){
            System.out.print(element+" ");
            Arrays.sort(arr);
        }
        System.out.println(arr);
    }
}