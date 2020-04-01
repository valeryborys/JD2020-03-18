package by.it.akhmelev.jd01_03;

class InOut {

    private InOut() {

    }

    static double[] getArray(String line) {
        line = line.trim();
        String[] parts = line.split(" ");
        double[] array = new double[parts.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(parts[i]);
        }
        return array;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i==arr.length-1) {
                System.out.println();
            }
        }
    }

}
