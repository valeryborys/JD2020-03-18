package by.it.sinevich.jd01_04;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        buildOneDimArray("123 99 88 77 66 5 4 3 1 0 2");
    }

    static void printMulTable() {
        int[][] mulTable = new int[10][10];
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == last) {
                    System.out.println("Index of last element=" + i);
                    break;
                }
            }
        }
}
