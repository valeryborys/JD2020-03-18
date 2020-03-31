package by.it.okatov.jd01_04;

class Helper {

    static double[] selectSort(double[] arr) {
        int end;
        double dSwap;
        for (int start = 0; start < arr.length - 1; start++) {
            end = start;
            for (int j = start + 1; j < arr.length; j++) {
                if (arr[j] < arr[end]) {
                    end = j;
                }
            }
            dSwap = arr[start];
            arr[start] = arr[end];
            arr[end] = dSwap;
        }

        return arr;
    }



    static void mergeSortIterative(double[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            for (int j = 0; j < arr.length - i; j += 2 * i) {
                merge(arr, j, j + i, Math.min(j + 2 * i, arr.length));
            }
        }
    }

    private static double[] merge(double[] arr, int left, int mid, int right) {
        int iter1 = 0;
        int iter2 = 0;
        double[] result = new double[right - left];

        while ((left + iter1 < mid) && (mid + iter2 < right)) {
            if (arr[left + iter1] < arr[mid + iter2]) {
                result[iter1 + iter2] = arr[left + iter1];
                iter1++;
            } else {
                result[iter1 + iter2] = arr[mid + iter2];
                iter2++;
            }
        }

        while (left + iter1 < mid) {
            result[iter1 + iter2] = arr[left + iter1];
            iter1++;
        }
        while (mid + iter2 > right) {
            result[iter1 + iter2] = arr[mid + iter2];
            iter2++;
        }

        for (int i = 0; i < iter1 + iter2; i++) {
            arr[left + i] = result[i];
        }

        return result;
    }

}
