package by.it.borys.jd01_04;

import by.it.borys.jd01_03.InOut;

import java.util.Scanner;
public class TaskC {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);

    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        //Helper.sort(array);

       System.out.println();
        InOut.printArray(array, "V", 4);
        System.out.println("first element="+binarySearch(array,first));
        System.out.println("last element="+binarySearch(array,last));


    }

   private static double[] mergeSort(double[] array) {

       if (array.length<2)return array;
       int left = 0;
       int right = array.length - 1;
       int m = (left + right) / 2;
       double[] array1 = new double[m+1];
       for (int i = 0; i <array1.length ; i++) {
           array1[i] = array[i];
       }
       double[] array2 = new double[right-m];
       for (int i = 0; i <array2.length ; i++) {
        array2[i] = array[m+1+i];
       }
        if (left < right) {
            array1 = mergeSort(array1);
            array2 = mergeSort(array2);

        }
       double[] arr = merge(array1,array2);
       for (int i = 0; i < array.length; i++) {
        array[i] = arr[i];
       }
       return array;

    }
   /*private static double[] mergeSort(double[] array, int left, int right) {
       if (array.length<2)return array;
          int m = (left + right) / 2;
       double[] array1 = new double[m];
       for (int i = 0; i <array1.length ; i++) {
           array1[i] = array[i];
       }
       double[] array2 = new double[array.length-m];
       for (int i = 0; i <array2.length ; i++) {
           array2[i] = array[m+i];
       }
       if (left < right) {
           mergeSort(array1, left, m);
           mergeSort(array2, m + 1, right);
           return merge(array1,array2);
       }
       else return array;
    }*/
    private static double[] merge(double[] part1, double[] part2) {
        double[] res = new double[part1.length + part2.length];
        int ileft = 0;
        int iright = 0;
        for (int i = 0; i < (res.length); i++) {
            if (ileft < part1.length && iright < part2.length) {
                if (part1[ileft] < part2[iright]) {
                    res[i] = part1[ileft];
                    ileft++;
                } else {
                    res[i] = part2[iright];
                    iright++;
                }
            } else if (ileft >= part1.length) {
                res[i] = part2[iright];
                iright++;
            } else {
                res[i] = part1[ileft];
                ileft++;
            }
        }
        return res;
    }

  static int binarySearch(double[] array, double value){
      int left = 0;
      int right = array.length;
      while (left <= right){
          int m = (left+right)/2;
          if (array[m] == value){
              return m;

          }
          else if (array[m]>value){
              right = m-1;
          }
          else left = m+1;
      } return 1000;
  }
}
