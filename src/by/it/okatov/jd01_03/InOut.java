package by.it.okatov.jd01_03;

class InOut {
    /***
     * Приватный конструктор
     */
    private InOut() {

    }


    /***
     * Метод-парсер входной строки типа String() в массив чисел типа double
     * @param line - входная строка чисел
     * @return - возвращает массив типа double
     */
    static double[] getArray(String line) {
        String[] parts = line.trim().split(" ");
        double[] dArray = new double[parts.length];

        for (int i = 0; i < dArray.length; i++) {
            dArray[i] = Double.parseDouble(parts[i]);
        }


        return dArray;
    }

    /***
     * Простая печать массива без излишеств
     * @param arr - входной массив
     */
    static void printArray(double[] arr) {
        for (double elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println("\n");
    }

    /***
     * Печать массива со всякими красивостями и форматированием строки
     * @param arr - входной массив
     * @param name - имя массива (будет напечатано рядом с каждым элементом массива)
     * @param columnCount - на сколько столбцов разбить массив
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d ] = %-8.3f ", name, i, arr[i]);

            if ((i + 1) % columnCount == 0 || i == (arr.length - 1)) {
                System.out.println("\n");
            }
        }
    }
}
