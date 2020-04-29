package by.it.lemesh.jd01_15;

import java.io.*;


public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        String fileName = getDir();
        writeMatrix(matrix, fileName);
        readMatrix(fileName);
    }


    private static int[][] getMatrix() {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31) - 15;
            }
        }
        return matrix;
    }

    private static String getDir() {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        return root + path + "matrix.txt";
    }

    private static void writeMatrix(int[][] matrix, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.printf("%3d ", ints[j]);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readMatrix(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while (null != (line = br.readLine())) System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
