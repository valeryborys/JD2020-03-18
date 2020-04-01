
package by.it.borys.jd01_03;

public class InOut {
    /**
     *
     * @param line входная строка
     * @return числовой массив
     */
    public static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] arr = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            arr[i] = Double.parseDouble(strArray[i]);

        }
    return arr;
    }

    /**
     * метод выводит массив в консоль
     * @param arr входной массив чисел
     *
     */
    static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


    }
    public static void printArray(double arr[], String name, int columnCount){

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%4.2f  ",name,i+1,arr[i]);
            if ((i+1)%columnCount ==0 || i==(arr.length-1)){
                System.out.println();
            }
        }

    }

}
