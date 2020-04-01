package by.it.novikov.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (min > arr[i]) min = arr[i];

        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (max < arr[i]) max = arr[i];

        }
        return max;

    }

    static void sort(double[] arr) {
        boolean sort;
        do {
            sort = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    double tm;
                    tm = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tm;
                    sort = true;

                }


            }

        } while (sort);
    }
}
