package by.it.okatov.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) {
        //createMatrix
        int[][] matrix = createMatrix();

        //getFileName
        String path = getFileName();

        //writeMatrixToFile
        writeMatrixToFile(matrix, path);
    }

    private static void writeMatrixToFile(int[][] matrix, String path) {
        try (PrintWriter print = new PrintWriter(path)) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    print.printf("%3d ", anInt);
                }
                print.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFileName() {
        Class<TaskA> aClass = TaskA.class;
        String fileName = "matrix.txt";
        return System.getProperty("user.dir") +
                       File.separator +
                       "src" +
                       File.separator +
                       aClass.getName().replace(".", File.separator).
                                                                            replace(aClass.getSimpleName(), "")
                       + fileName;
    }

    private static int[][] createMatrix() {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31 - 15);
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
        return matrix;
    }
}
