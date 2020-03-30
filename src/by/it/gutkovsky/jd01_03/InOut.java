package by.it.gutkovsky.jd01_03;

/**
 * @author Dmitriy Gutkovsky
 * @version revision 1 TASK 3
 * <p>
 * Class InOut: response for the input parameters and output data
 */

 class InOut {

    /**
     * As input gets String line, performs it into array of String and then to array  of double
     *
     * @param s input String line
     * @return array of double
     */
    static double[] getArray(String s) {

        String[] incomingLine = s.trim().split(" ");
        double[] array = new double[incomingLine.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(incomingLine[i]);
        }
        return array;
    }

    // обычный вывод массива

    /**
     * Print array in format: element - space
     *
     * @param arr array of double
     */
    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // вывод массива под заданный фомрат

    /**
     * This method print incoming array in next format: name [ i ]= array[i]. Quantity of output columns specified by parameter columnCount.
     *
     * @param arr         double[] array
     * @param name        String, name of the element / array
     * @param columnCount quantity of columns (how array should be print)
     */

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            // element[ x ] = arr[i]
            System.out.printf("%s[% -3d]=%-8.2f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i == arr.length - 1)) {
                System.out.println();
            }
        }
    }

    /**
     * Description: print array in next format: element [ i ][ j ] = array [i][j]. Each row starts  print from a new line.
     *
     * @param matrix1 double[][] array
     */

    static void printMatrix(double[][] matrix1) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.printf("%s[% -3d][% -3d]=%-8.2f", "element", i, j, matrix1[i][j]);
//                System.out.println(matrix1[i][j]);
            }
            System.out.println();
        }
    }


}
