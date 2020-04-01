package by.it.bobrovich.jd01_03;

import java.util.*;

public class Helper {
    public static void main(String[] args) {

    }

    /**
     *
     * @param array входной массив
     * @return возвращает минимальный элемент
     */
    static double findMin(double array[]){
        double min = array[0];
        for (double anArray : array) {
            if (min > anArray) {
                min = anArray;
            }
        }
        return min;
    }

    /**
     *
     * @param array входной массив
     * @return возврвщает минимальный элемент
     */
    static double findMax(double array[]){
        double max = 0;
        for (double anArray : array) {
            if (max < anArray) {
                max = anArray;
            }
        }
        return max;
    }

    /**
     *
     * @param array входной массив
     */
    static void sort(double array[]){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min] > array[j]){
                    min = j;
                }
            }
            double tmp = array[i];
            array[i]=array[min];
            array[min] = tmp;
        }
    }

    /**
     *
     * @param matrix входная матрица
     * @param vector входной вектор
     * @return возвращает результат произведения матрицы и вектора
     */
    static double[] mul(double[][] matrix, double[] vector){
        double[] newmatrix = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newmatrix[i] = newmatrix[i] + matrix[i][j]*vector[j];
            }
        }
        return newmatrix;
    }

    /**
     *
     * @param matrixLeft входная левая матрица
     * @param matrixRight входная правая матрица
     * @return возвращает результат произведения матриц
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] newmatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newmatrix[i][j] = newmatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return newmatrix;
    }

}
