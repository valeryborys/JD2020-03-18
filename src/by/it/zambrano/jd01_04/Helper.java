package by.it.zambrano.jd01_04;

import java.util.Arrays;

public class Helper {
    static void sort(double[] arr){
        for (int last = arr.length-1; last >1 ; last--) {
            for (int i = 0; i <last ; i++) {
                if(arr[i]>arr[i+1]){
                    double buf=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buf;
                }
            }

        }
    }
}