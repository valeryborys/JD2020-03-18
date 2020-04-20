package by.it.borys.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        String fileName = dir(TaskA.class) + "matrix.txt";
        matrixToFile(fileName);
        readToConsole(fileName);
    }

    private static String dir(Class<?> dir) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clD = dir.getName().replace("TaskA", "").replace(".", File.separator);
        return path + clD;
    }

    private static void matrixToFile(String fileName) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31 - 15);
            }
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < matrix.length; i++) {
                pw.printf("%3d %3d %3d %3d ", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]);
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readToConsole(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (DataInputStream dis = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(fileName)
                        )
                )
           ) {
            int b = 0;
            while ((b = dis.read()) > 0) {
                sb.append((char) b);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
