package by.it.szamostyanin.jd01_03;
/*
A. Реализуйте статические методы ввода и простого/форматного вывода для одномерных
массивов типа double. Разместите эти методы в классе by.it.familiya.jd01_03.InOut
 Сигнатура для ввода: static double[ ] getArray(String line)
 Сигнатуры для вывода: static void printArray(double[ ] arr) (используйте System.out.print)
 ( а тут printf ) static void printArray(double[ ] arr, String name, int columnCount)

B. Реализуйте статические методы для поиска минимального и максимального значения в
одномерном массиве для типа double. Реализуйте статические методы для сортировки по
возрастанию одномерных массивов типа double. Разместите эти методы в классе
by.it.familiya.jd01_03.Helper.
 Сигнатуры: static double findMin(double[ ] arr)
 static double findMax(double[ ] arr)
 static void sort(double[ ] arr)

C. Реализуйте умножение матрицы на вектор, матрицы на матрицу для типа double. Разместите
статические методы в классе by.it.familiya.jd01_03.Helper.
 Сигнатуры: static double[ ] mul(double[ ][ ] matrix, double[ ] vector)
 static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight)
 Реализуйте класс by.it.familiya.jd01_03.Runner в котором проверьте все разработанные
методы (проверьте ввод-вывод одномерных массивов, проверьте сортировку и поиск
минимума/максимума в одномерном массиве, операции матричного умножения).
 Добавьте JavaDoc к разработанным методам
 */

public class InOut {
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length )
                System.out.println();
        }
    }
}
