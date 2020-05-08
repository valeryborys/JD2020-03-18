package by.it.novikov.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {
    /**
     * Возвращает строку, введенную пользователем
     * @return строку
     * @throws IOException
     */
     static String consoleReadLine() throws IOException {
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isReader);
        return reader.readLine();
    }

    /**
     * Превращение строки в массив
     * @param line - введение исходного массива
     * @return массив типа double
     */
     static double[] getArray (String line){
        String[] stringArray = line.trim().split(" ");
        double[] array = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Double.parseDouble(stringArray[i]);
        }
        return array;
    }

    /**
     * Печатает массив типа double
     * @param arr - массив типа double
     */
     static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Печатает массив типа double
     * @param arr - массив типа double
     * @param name - название переменной
     * @param columnCount - количество столбцов
     */
     static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-2d]=%-8.4f ", name, i, arr[i]);
            if ((i+1)%columnCount == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Печатает массив массивов типа double
     * @param arr - массив массивов типа double
     */
     static void printArray (double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("[ %-8.4f ]", arr[i][j]);
                }
            System.out.println();
        }
        System.out.println();
    }

}