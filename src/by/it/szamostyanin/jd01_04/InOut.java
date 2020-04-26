package by.it.szamostyanin.jd01_04;

public class InOut {
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] strArr2 = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = Double.parseDouble(strArr[i]);
        }
        return strArr2;
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
