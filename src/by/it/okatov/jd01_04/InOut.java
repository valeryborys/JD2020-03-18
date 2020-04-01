package by.it.okatov.jd01_04;

class InOut {
    private InOut() {

    }


    static double[] getArray(String line) {
        String[] parts = line.trim().split(" ");
        double[] dArray = new double[parts.length];

        for (int i = 0; i < dArray.length; i++) {
            dArray[i] = Double.parseDouble(parts[i]);
        }


        return dArray;
    }

    static void printArray(double[] arr) {
        for (double elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println("\n");
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-3d]=%-8.3f ", name, i, arr[i]);

            if ((i + 1) % columnCount == 0 || i == (arr.length - 1)) {
                System.out.println("\n");
            }
        }
        System.out.println();

        //System.out.println();
    }
}
