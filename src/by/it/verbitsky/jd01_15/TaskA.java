package by.it.verbitsky.jd01_15;

import java.io.*;

class TaskA {
    private static final String fName = "matrix.txt";
    private static final int rowCount = 6;
    private static final int colCount = 4;

    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        //пишем массив в файл
        writeTextFile(getFullPath(TaskA.class, fName), matrix);
        //читаем массив из файла и выводим на консоль
        printMatrix(getMatrixFromFile(getFullPath(TaskA.class, fName)));

    }

    public static int getRowCount() {
        return rowCount;
    }

    public static int getColCount() {
        return colCount;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int number : ints) {
                System.out.printf("%3d ", number);
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixFromFile(String fileName) {
        int[][] matrix = new int[getRowCount()][getColCount()];
        int lineNum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                matrix[lineNum++] = getArrayFromLine(reader.readLine(), matrix[0].length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matrix;
    }

    private static int[] getArrayFromLine(String readLine, int size) {
        int[] array = new int[size];

        String[] strings = readLine
                .replace("\n", "")
                .trim()
                .split("\\s+");
        for (int i = 0; i < strings.length; i++) {
            try {
                array[i] = Integer.parseInt(strings[i]);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return array;
    }

    private static int[][] createMatrix() {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (int) ((Math.random() * (31)) - 15);
            }
        }
        return matrix;
    }

    private static String getFullPath(Class<?> aClass, String name) {
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(aClass.getName()
                        .replace('.', File.separatorChar)
                        .replace(aClass.getSimpleName(), ""))
                .append(name);
        return fullPath.toString();
    }

    private static void writeTextFile(String fName, int[][] array) {
        try (PrintWriter writer = new PrintWriter(fName)) {
            for (int[] ints : array) {
                for (int element : ints) {
                    writer.printf("%3d ", element);
                }
                writer.print("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
