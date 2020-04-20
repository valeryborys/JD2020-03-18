package by.it.gutkovsky.jd01_15;

import java.io.*;

class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        createMatrix(matrix);
        String fileMatrix = getFileName(TaskA.class, "matrix.txt");
        printToFileTxt(matrix, fileMatrix);
        readFromTxtFileAndPrintToConsole(fileMatrix);
    }

    private static void createMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31 - 15);
            }
        }
    }

    private static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }

    private static void printToFileTxt(int[][] matrix, String fileMatrix) {
        try (PrintWriter fileWrite = new PrintWriter(fileMatrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    fileWrite.printf("%3d ", matrix[i][j]);
                }
                fileWrite.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromTxtFileAndPrintToConsole(String fileMatrix) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileMatrix))) {
            while (reader.ready()){
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
}
