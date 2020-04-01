package by.it.sinevich.jd01_03;

public class InOut {
    static double[] getArray(String line){
        String[] s=line.split(" ");
        double[] array = new double[s.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Double.parseDouble(s[i]);
        }
        return array;
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v+" ");
        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]= %6.4f ", name, i, arr[i]);
            if((i+1)%columnCount==0 || i==arr.length-1){
                System.out.println();
            }
        }
        System.out.println();
    }
}
