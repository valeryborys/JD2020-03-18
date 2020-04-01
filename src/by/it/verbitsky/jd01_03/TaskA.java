package by.it.verbitsky.jd01_03;

public class TaskA {
    public static void main(String[] args) {
        double[] mas = new double[]{1, 3, 2, 5, 7, 6, 11, 9,1,1,1,1,1,1,1,1,1};
        System.out.println("исходный массив:");
        InOut.printArray(mas);
        System.out.println();
        System.out.println("сортированный массив:");
        mas = InOut.mergeSort(mas);
        InOut.printArray(mas);
       // InOut.printArray(mas, "arr", 4);
    }
}
