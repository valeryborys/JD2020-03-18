package by.it.gutkovsky.jd01_04;

import java.util.Scanner;

 class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
//        buildOneDimArray("1.1 3.3 2.2 5.5 7.7 8.8 6.6 4.4 9.9 0.0");
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        System.out.println();

        mergeSort(array);
        InOut.printArray( array, "V", 5);
        System.out.println("Index of first element=" + binarySearch(array, start));
        System.out.println("Index of last element=" + binarySearch(array, stop));
    }

    static void mergeSort(double[ ] array) {
        mergeSort(array, 0, array.length);
    }

     static void mergeSort(double[] a, int leftBorder, int rightBorder) {
        if (leftBorder + 1 < rightBorder) {
            int middle = (leftBorder + rightBorder) / 2;
            mergeSort(a, leftBorder, middle);
            mergeSort(a, middle, rightBorder);
            //merge array
            int size = rightBorder - leftBorder;
            double[] b = new double[size];
            int i = leftBorder;
            int j = middle;
            for (int k = 0; k < size; k++) {
                if (j >= rightBorder || i < middle && a[i] < a[j]) {
                    b[k] = a[i];
                    i++;
                } else {
                    b[k] = a[j];
                    j++;
                }
            }
            System.arraycopy(b, 0, a, leftBorder, size);
        }
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

     */

}








