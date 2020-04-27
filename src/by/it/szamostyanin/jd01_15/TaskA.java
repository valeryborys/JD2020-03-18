package by.it.szamostyanin.jd01_15;

import java.io.*;

public class TaskA {

    private static String getFileName(Class<?> aClass, String aName) {
        String path = aClass.getName().replace(".", File.separator);
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path.replace(aClass.getSimpleName(), "");
        return root + path + aName;
    }

    public static void main(String[] args) {
        String filename = getFileName(TaskA.class, "matrix.txt");
        writeMatrix(filename);
        System.out.println(readMatrix(filename));
    }

    private static void writeMatrix(String filename) throws RuntimeException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            int[][] matrix = new int[6][4];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = (int) ((Math.random() * 31) - 15);
                    pw.printf("%3d ", matrix[i][j]);
                }
                pw.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder readMatrix(String filename) throws RuntimeException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine()).append("\n");
            }

            return sb;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}