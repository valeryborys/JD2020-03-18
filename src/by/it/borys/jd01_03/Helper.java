package by.it.borys.jd01_03;

public class Helper {
    static double findMin(double arr[]) {
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        } else {
            double min = arr[0];
            for (double el : arr) {
                if (min > el) min = el;
            }
            return min;
        }
    }

    static double findMax(double arr[]) {
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double el : arr) {
                if (max < el) max = el;
            }
            return max;
        }
    }

   public static void sort(double[] arr) {
        int i = 1;
        double temp;
        while (i < arr.length) {
            if (i == 0 || arr[i - 1] <= arr[i]) {
                i++;
            } else {
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;

            }
        }
        for (double elem : arr) {
            System.out.print(elem + " ");

        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        if (matrix[0].length != vector.length) {
            System.out.println("Число столбцов матрицы не равно числу строк ветора!");
        } else {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    res[i] += matrix[i][j] * vector[j];
                }
            }


            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
            return res;



    }
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft[0].length != matrixRight.length) {
            System.out.println("Число столбцов левой матрицы не равно числу строк правой матрицы!");
        } else {
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[i].length; j++) {
                    for (int k = 0; k < matrixRight.length ; k++) {
                        res[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
                    }

                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
        return res;
    }
}
