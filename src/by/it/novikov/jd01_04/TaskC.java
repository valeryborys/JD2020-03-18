package by.it.novikov.jd01_04;

public class TaskC {
    public static void main(String[] args) {

    }

    static void mergeSort(double[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(double[] array, int left, int right) {
        int mid = (left + right) / 2;
        double[] leftArray = new double[mid - left];
        double[] rightArray = new double[right - mid];
        for (int i = left; i < mid; i++) leftArray[i - left] = array[i];
        for (int i = mid; i <= right; i++) leftArray[i - mid] = array[i];
        mergeSort(leftArray);
        mergeSort(rightArray);
        double[] result = merge(leftArray, rightArray);
        for (int i = left; i < right; i++) {
            array[i] = result[i - left];

        }

    }

    private static double[] merge(double[] leftArray, double[] rightArray) {
        double[] res = new double[leftArray.length + rightArray.length];
        int indexLesft = 0;
        int indexRight = 0;
        int i = 0;
        if (leftArray[indexLesft] < rightArray[indexRight])
            res[i++] = leftArray[indexLesft++];
        else
            res[i++] = rightArray[indexRight++];
        return res;


    }
}