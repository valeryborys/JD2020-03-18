package by.it.tolstik.jd01_15;

import java.io.*;
import java.util.Comparator;

class TaskB implements Const{

    private static String name = "TaskB.txt";

    private static String dir(Class<?> aClass) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName().replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir;
    }

    public static void main(String[] args) {
        //1
        //2
        /*3*/
        /*4*/
        /**5*/
        saveToFile(name);
//        Comparator
    }

    private static StringBuilder deleteAllComments() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader
                (new FileReader(dir(TempCodeTaskB.class) + "TaskB.java"))) {
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output).append("\n");
            }
            StringBuilder result = new StringBuilder(sb);
            int start = 0;
            int end;
            boolean flag = true;
            while (flag) {
                try {
                    if (result.indexOf(a1, start) > 0) {
                        start = result.indexOf(a1, start);
                        end = result.indexOf(a2, start);
                        result.delete(start, end);
                        continue;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException(e);
                }
                flag = false;
            }
            start = 0;
            end = 0;
            flag = true;
            while (flag) {
                try {
                    if (result.indexOf(b1, end) > 0) {
                        start = result.indexOf(b1, start);
                        end = result.indexOf(b2, start) + 2;
                        result.delete(start, end);
                        end += 2;
                        continue;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException(e);
                }
                flag = false;
            }
            return result;


        } catch (IOException e) {
            e.getStackTrace();
        }
        return sb;
    }

    private static void saveToFile(String name) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dir(TaskB.class) + name))) {
            pw.print(deleteAllComments());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
