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
        String filename = getFileName(TaskA.class,"matrix.txt");
        writeMatrix(filename);
        //readMatrix();
        //consoleMatrix();

    }

    private static void writeMatrix(String filename) throws RuntimeException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            int[][] matrix = new int[6][4];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = (int) ((Math.random() * 31) - 15);
                    //System.out.printf("%3d ",matrix[i][j]);
                    pw.printf("%3d ",matrix[i][j]);
                }
                //System.out.println();
                pw.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*private static List<Integer> readMatrix(String filename) {
        try () {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ;
    }

    private static void consoleMatrix(String filename) {
            System.out.printf("%3d ",matrix[i][j]);
        }
        System.out.prinln();
    }*/
}