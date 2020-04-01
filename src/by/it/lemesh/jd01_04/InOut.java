package by.it.lemesh.jd01_04;


public class InOut {
    static double[] getArray(String line) {
        String[] strArr = line.trim().split(" ");
        double[] doubleArr = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            doubleArr[i] = Double.parseDouble(strArr[i]);
        }
        return doubleArr;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int col) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ", name, i, array[i]);
            if ((i + 1) % col == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
