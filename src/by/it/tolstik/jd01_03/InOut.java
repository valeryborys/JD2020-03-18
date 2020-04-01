package by.it.tolstik.jd01_03;


class InOut {
    /**
     *
     * @param line scanning input line
     * @return array
     */
    static double[] getArray(String line) {
        String[] lineArr = line.trim().split(" ");
        double[] arr = new double[lineArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(lineArr[i]);
        }
        return arr;
    }

    /**
     *
     * @param arr array
     */
    static void printArray(double[] arr) {
        for (double elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr array
     * @param name name array
     * @param columnCount how many column you want to see in console
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%.2f ",name,i,arr[i]);
            if ((i+1) % columnCount == 0 || (i == arr.length - 1)) {
                System.out.println();
            }
        }
    }

}

