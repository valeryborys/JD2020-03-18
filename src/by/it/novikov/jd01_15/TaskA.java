package by.it.novikov.jd01_15;

import java.io.*;
import java.util.Random;

class TaskA {

    private static final Random random = new Random();
    private static String fileName = Helper.getPath( "matrix.txt", TaskA.class);

    public static void main(String[] args) {
        int [][] matrix = createMatrix (6,4);
        printMatrix(matrix);
        writeMatrixToFile(matrix);
        readFileToConsole(fileName);
    }

    private static int[][] createMatrix(int rows, int cols) {
        boolean max = false;
        boolean min = false;
        int[][] createdMatrix = new int[rows][cols];
        while (!max || !min) {
            max = false;
            min = false;
            for (int i = 0; i < createdMatrix.length; i++) {
                for (int j = 0; j < createdMatrix[0].length; j++) {
                    int randomInt = random.nextInt(31) - 15;
                    if (randomInt == 15){
                        max = true;
                    }
                    else if(randomInt == -15){
                        min = true;
                    }
                    createdMatrix[i][j] = randomInt;
                }
            }
        }
        return createdMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                System.out.print(rows[cols] + " ");
            }
        }
        System.out.println();
    }

    private static void writeMatrixToFile(int[][] matrix) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)){
            for (int[] rows : matrix) {
                for (int cols = 0; cols < matrix[0].length; cols++) {
                    printWriter.printf("%3d ", rows[cols]);
                }
                printWriter.printf("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileToConsole(String fileName) {
        try (FileReader fileReader = new FileReader(fileName))
        {
        while (fileReader.ready()) {
            int oneSymbol = fileReader.read();
            System.out.printf("%c",(char) oneSymbol);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}