package by.it.szamostyanin.jd01_04;

public class TaskC {
    public static void main(String[] args) {
        String line = "5 6 3 2 1 9 8 7 4";
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        line = line.trim();
        String[] strD = line.split(" ");
        double[] arr = new double[strD.length];
        for (int i = 0; i < strD.length; i++) {
            if (!strD[i].equals(" "))
                arr[i] = Double.parseDouble(strD[i]);
        }

        double first = arr[0];
        double last = arr[arr.length - 1];
        mergeSort(arr);

        InOut.printArray(arr, "V", 4);
        int firstIn = binarySearch(arr, first);
        int lastIn = binarySearch(arr, last);
        System.out.println("Index of the first element=" + firstIn);
        System.out.println("Index of the last element=" + lastIn);

    }

    static void mergeSort(double[] arr) {
        if (arr.length < 2) return;
        int m = arr.length / 2;
        double[] arr1 = new double[m];
        double[] arr2 = new double[arr.length - m];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, m, arr2, 0, arr.length - m);
        mergeSort(arr1);
        mergeSort(arr2);
        double[] res = merge(arr1, arr2);
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    static double[] merge(double[] masF, double[] masS) {
        int n = masF.length + masS.length;
        double[] arr = new double[n];
        int masFIn = 0;
        int masSIn = 0;
        for (int i = 0; i < n; i++) {
            if (masFIn == masF.length) {
                arr[i] = masS[masSIn];
                masSIn++;
            } else if (masSIn == masS.length) {
                arr[i] = masF[masFIn];
                masFIn++;
            } else {
                if (masF[masFIn] < masS[masSIn]) {
                    arr[i] = masF[masFIn];
                    masFIn++;
                } else {
                    arr[i] = masS[masSIn];
                    masSIn++;
                }
            }
        }
        return arr;
    }

    static int binarySearch(double[] array, double value) {
        int f = 0;
        int s = array.length - 1;
        int m;
        while (f <= s) {
            if ((s - f) < 2) {
                if (array[f] == value) {
                    return f;
                }
                if (array[s] == value)
                    return s;
            }
            m = (s + f) / 2;
            if (array[m] == value) {
                return m;
            } else if (array[m] < value) {
                f = m + 1;
            } else if (array[m] > value) {
                s = m - 1;
            }
        }
        return -1;
    }
}
