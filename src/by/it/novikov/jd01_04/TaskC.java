package by.it.novikov.jd01_04;

public class TaskC {
    public static void main(String[] args) {

        buildOneDimArray("1 8 11 5 8 7 9");
        double[] array = {2, 6, 4, 1, 0, 10, 11, 9};

        mergeSort(array);
        printArray(array);

    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int firstIndex = binarySearch(array, firstElement);
        int lastIndex = binarySearch(array, lastElement);
        System.out.println("Index of first element=" + firstIndex);
        System.out.println("Index of last element=" + lastIndex);
    }



    private static void mergeSort(double[] array) {
        double[] temp = mergeSort(array, 0, array.length);
        System.arraycopy(temp, 0, array, 0, array.length);
    }



    private static double[] mergeSort(double[] array , int left, int right) {
        if (right > 1) {
            int mid = right / 2;
            double[] leftArr = new double[mid];
            double[] rightArr = new double[right - mid];
            for (int i = 0; i < mid; i++) {
                leftArr[i] = array[i];
            }
            leftArr = mergeSort(leftArr, 0, mid);
            int counter = 0;
            for (int i = mid; i < right; i++) {
                rightArr[counter++] = array[i];
            }
            rightArr = mergeSort(rightArr, mid, right - mid);
            array = merge(leftArr, rightArr);
        }
        return array;

    }




    private static void printArray(double[] arr) {
        for (double a : arr
        ) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static double[] merge(double[] part1, double[] part2) {
        double array[] = new double[part1.length + part2.length];
        int r = 0, j = 0, i = 0;
        while (j < part1.length && i < part2.length) {
            if (part1[j] < part2[i])
                array[r++] = part1[j++];
            else
                array[r++] = part2[i++];
        }
        while (j < part1.length)
            array[r++] = part1[j++];
        while (i < part2.length)
            array[r++] = part2[i++];
        return array;
    }


    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        do {
            int med = (right + left) / 2;
            if (array[med] == value) {
                return med;

            } else if (array[med] > value) {
                right = med - 1;
            } else if (array[med] < value) {
                left = med + 1;
            }
        }
        while (true);

    }
}