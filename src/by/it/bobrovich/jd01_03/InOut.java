package by.it.bobrovich.jd01_03;


public class InOut {
    public static void main(String[] args){

    }

    /**
     *
     * @param line входная строка
     * @return возвращает массив элементов входной строки
     */
    static double[] getArray(String line){
        String[] array = line.split(" ");
        double[] array1 = new double[array.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Double.parseDouble(array[i]);
        }
        return  array1;
    }

    /**
     *
     * @param array входной массив
     */
    static void printArray(double[] array){
        for (double anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    /**
     *
     * @param array входной массив
     * @param name имя массива на экране
     * @param columnCount кол-во столбцов
     */
    static void printArray(double[] array, String name, int columnCount){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(count != columnCount){
                count += 1;
                System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            } else{
                count = 1;
                System.out.println();
                System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            }
        }
    }



}
