package by.it.novikov.jd01_03;


public class InOut {
    /**
     * @param line - получает строку символов
     * @return возвращает массив типа double
     */
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    /**
     *
     * @param arr - получает массив типа double
     */
    static void printArray(double[] arr) {

        for (double element : arr) {
            System.out.print(element + " ");
            System.out.println();
        }

    }

    /**
     *
     * @param arr массив типа double
     * @param name Имя массива
     * @param columnCount кол-во колонок, на которое разделить массив
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%3d]=%7.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length) System.out.println();


        }
    }


}