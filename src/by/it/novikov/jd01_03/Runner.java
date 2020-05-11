package by.it.novikov.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String sample = "3 2 5";
        double[] array = InOut.getArray(sample);
        InOut.printArray(array);
        InOut.printArray(array, "Name", 2);
        InOut.printArray(array, "ABmmd", 3);
        System.out.println(Helper.findMax(array));
        System.out.println(Helper.findMin(array));
        Helper.sort(array);
        InOut.printArray(array);
        double[][] multiArr = {{1, 2, 3}, {2, 2, 2}, {2,3,4}};
        double [][] multiMatrix = Helper.mul(multiArr, multiArr);
        InOut.printArray(multiMatrix);
        double [] multiMatrArr = Helper.mul(multiArr, array);
        InOut.printArray(multiMatrArr, "rrr", 2);

        
    }
}