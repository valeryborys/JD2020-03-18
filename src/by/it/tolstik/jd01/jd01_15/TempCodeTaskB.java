package by.it.tolstik.jd01.jd01_15;

import java.io.*;

class TempCodeTaskB implements Const{

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
        /*4
         *
         *
         * */
        /**5
         * */
        saveToFile(name);
    }

    private static StringBuilder deleteAllComments() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader
                (new FileReader(dir(TempCodeTaskB.class) + "TempCodeTaskB.java"))) {
            String output;
            while ((output = br.readLine()) != null) {
                if (output.contains(a1) | output.contains(B3)) {
                } else {
                    sb.append(output).append("\n");
                }
            }
            System.out.println(sb);
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
