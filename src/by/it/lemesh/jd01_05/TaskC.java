package by.it.lemesh.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        double[] A = new double[31];
        int i = 0;
        int j = 0;
        System.out.println("Массив A[] ");
        for (double x = 5.33; x <= 9; x += 0.12) {
            A[j] = Math.pow(x * x + 4.5, 1. / 3);
            System.out.printf("A[%3d] = %g ", j, A[j]);
            j++;
            if (j % 5 == 0) {
                System.out.println();
            }
            if (A[j - 1] > 3.5) {
                i++;
            }
        }
        int index = 0;
        double[] B = new double[i];
        System.out.println();
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int k = 0; k < A.length; k++) {
            if (A[k] > 3.5) {
                B[index] = A[k];
                System.out.printf("B[%3d] = %8.6f ", index, B[index]);
                index++;
                if (index % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
