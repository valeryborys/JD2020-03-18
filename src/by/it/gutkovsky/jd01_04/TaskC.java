package by.it.gutkovsky.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        buildOneDimArray(line);
        buildOneDimArray("1.1 3.3 2.2 5.5 7.7 8.8 6.6 4.4 9.9 0.0");
//        buildOneDimArray("-11.191147487923075, -11.12123627299679, 3.0039157249290334, -10.129955982133318, 11.929385434226909, 14.650202918905613, -2.946778864650863, 1.2899254037837835, 3.8258610084640274, 14.73456171463032, -8.225141291326914, -9.07365057587573, 13.418177917441447, -3.1993109483490585, -6.082214935247757");
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        System.out.println();

        mergeSort(array);
        InOut.printArray(array);

//        InOut.printArray( mergeSort(array), "V", 5);
//        System.out.println("Index of first element=" + binarySearch(mergeSort(array), start));
        System.out.println("Index of first element=" + binarySearch(Helper.sort(array), start));
//        System.out.println("Index of last element=" + binarySearch(mergeSort(array), stop));
        System.out.println("Index of last element=" + binarySearch(Helper.sort(array), stop));


    }

    static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length);

    }
// рабочий вариант
    /*
    public static void mergeSort(double[] a, int low, int high) {
        if (low + 1 < high) {
            int mid = (low + high) >>> 1;
            mergeSort(a, low, mid);
            mergeSort(a, mid, high);

            int size = high - low;
            double[] b = new double[size];
            int i = low;
            int j = mid;
            for (int k = 0; k < size; k++) {
                if (j >= high || i < mid && a[i] < a[j]) {
                    b[k] = a[i++];
                } else {
                    b[k] = a[j++];
                }
            }
            System.arraycopy(b, 0, a, low, size);
        }

    }

     */

    private static void mergeSort(double[] array, int left, int right) {
        double [] temp = new double[array.length];
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
        }

        merge(array,array);






    }


    /* - сортирует, но не проходит тест
        static double[] mergeSort(double[] array) {
            if (array == null) {
                return null;
            }
            // проверяем не 1 ли элемент в массиве?
            if (array.length < 2) {
                return array;
            }
            // копируем левую часть от начала до середины
            double[] arrayB = new double[array.length / 2];
            System.arraycopy(array, 0, arrayB, 0, array.length / 2);

            // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
            double[] arrayC = new double[array.length - array.length / 2];
            System.arraycopy(array, array.length / 2, arrayC, 0, array.length - array.length / 2);

            // рекурсией закидываем поделенные обе части обратно в метод, он будет крутится до тех пор,
            // пока не дойдет до 1 элемента в массиве
            arrayB = mergeSort(arrayB); // левая часть возврат из рекурсии строкой return array;
            arrayC = mergeSort(arrayC); // правая часть возврат из рекурсии строкой return array;

            // рекурсия возврата слияния двух отсортированных массивов
            return merge(arrayB, arrayC);
        }
*/
    private static double[] merge(double[] part1, double[] part2) {
        double[] mergeArray = new double[part1.length + part2.length];
        int i = 0, j = 0;
        for (int k = 0; k < mergeArray.length; k++) {
            if (i > (part1.length - 1)) {
                mergeArray[k] = part2[j];
                j++;
            } else if (j > (part2.length - 1)) {
                mergeArray[k] = part1[i];
                i++;
            } else if (part1[i] < part2[j]) {
                mergeArray[k] = part1[i];
                i++;
            } else {
                mergeArray[k] = part2[j];
                j++;
            }
        }
        return mergeArray;
    }


    static int binarySearch(double[] array, double value) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m] == value) {
                return m;
            } else if (array[m] > value) {
                r = m - 1;
            } else l = m + 1;
        }
        return -1;


    }
}








