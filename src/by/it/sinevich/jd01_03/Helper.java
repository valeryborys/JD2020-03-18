package by.it.sinevich.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
        double min;
        if(0==arr.length)
            return Integer.MIN_VALUE;
        else{
            min = arr[0];
            for (double element : arr) {
                if (element<min){
                    min=element;
                }
            }
        }
        return min;
    }
    static double findMax(double[] arr){
        double max;
        if(0==arr.length) {
            return Integer.MAX_VALUE;
        }
            else{
                max=arr[0];
                for (double m : arr) {
                    if(m>max){
                        max=m;
                    }
                }
            }
        return max;
        }

    static void sort(double[] arr){
        double x;
        boolean swap;
        int last=arr.length-1;
        do {
            swap=false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    x = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = x;
                    swap=true;
                }
            }
            last--;
        }
        while (swap);
    }
    static double[] mul(double[][] matrix, double[] vector){
        double[] x = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                x[i]=x[i] + matrix[i][j] * vector[j];
            }
        }
        return x;
    }
   static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] x = new double[matrixLeft.length][matrixRight[0].length];
       for (int i = 0; i < matrixLeft.length; i++) {
           for (int j = 0; j < matrixRight[0].length; j++) {
               for (int k = 0; k < matrixRight.length; k++) {
                   x[i][j]=x[i][j]+matrixLeft[i][k]*matrixRight[k][j];
               }
           }
       }
       return x;
   }
}
