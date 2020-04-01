package by.it.szamostyanin.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] result = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            result[i] = Double.parseDouble(strArr[i]);
        }
        return result;
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v);
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length)
                System.out.println();
        }
    }
}
