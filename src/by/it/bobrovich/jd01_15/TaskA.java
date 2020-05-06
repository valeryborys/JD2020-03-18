package by.it.bobrovich.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskA {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clPath;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 32 - 16);
            }
        }

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(
                        dir(TaskA.class) + "matrix.txt")
                )
        ) {
            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    pw.printf("%3d ", ints[j]);
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.lines(Paths.get(dir(TaskA.class) + "matrix.txt"))
                    .forEach((System.out::println));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
