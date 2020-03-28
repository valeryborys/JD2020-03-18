package by.it.borys.jd01_04;

/*import by.it.borys.jd01_03.InOut;

import java.util.Scanner;
public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
       // buildOneDimArray(line);
       double[] part1 = new double[]{1, 3, 4, 8, 15};
        double[] part2 = new double[]{40};
        double[] array = merge(part1, part2);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
            }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        //mergeSort(array);
        System.out.println();
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }

    }

    static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length - 1;
        int m = (left + right) / 2;
        if (left < right) {
            merge(mergeSort(array, left, m), mergeSort(array, m + 1, right));
        }
       else return;
    }
   private static void[] mergeSort(double[] array, int left, int right) {
        int m = (left + right) / 2;
        if (left < right) {
            merge(mergeSort(array, left, m), mergeSort(array, m + 1, right));
        }
        else return;

    }
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
}


*/