package by.it.lemesh.jd01_15;
// ерунда
import java.io.*;

public class TaskB {
    private static String[] comments = new String[3];

    public static void main(String[] args) {
        String fileName = getDir("characters.txt");
        comments = getCharacter(fileName);
        fileName = getDir("TaskB.java");
        StringBuilder sb = getFile(fileName);
        singleLineDelete(sb);
        multiLineDelete(sb);
        fileName = getDir("TaskB.txt");
        writeTxt(sb, fileName);
        System.out.println(sb.toString());
    }

    /**
     * @param fileName
     * @return
     */
    private static String[] getCharacter(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i < 3; i++) {
                comments[i] = br.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comments;
    }

    private static String getDir(String name) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
// ерунда
        return root + path + name;
    }

    private static StringBuilder getFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while (null != (line = br.readLine())) {
/*
                if (line.contains(comments[0]))
                    sb.append("\n");
                else*/
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static void singleLineDelete(StringBuilder sb) {
        int start = sb.indexOf(comments[0]);
        int end;
        // комментарий
        while (start >= 0) {
            end = sb.indexOf("\n", start);
            sb.delete(start, end);
            start = sb.indexOf(comments[0]);
        }
    }

    private static void writeTxt(StringBuilder sb, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void multiLineDelete(StringBuilder sb) {
        int start = sb.indexOf(comments[1]);
        int end;
        while (start >= 0) {
            end = sb.indexOf(comments[2]);
            sb.delete(start, end + 2);
            start = sb.indexOf(comments[1]);
        }

    }
    /*
        private static int[][] getMatrix() {
            int[][] matrix = new int[6][4];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = (int) (Math.random() * 31) - 15;
                }
            }
            return matrix;
        }*/
}