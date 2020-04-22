package by.it.tolstik.jd01_15;

import java.io.*;
import java.util.Scanner;

class TempCodeTaskB implements ConstForChar{

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
                char[] chars = output.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == a1) {
                        if (chars[i+1] == a1) {
                            for (int j = i; j < chars.length; j++) {
                                chars[j] = ' ';
                                output = String.valueOf(chars[j]);
                            }
                        }
                        if (chars[i+1] == a3) {
                            if (output.indexOf(a3,2) == -1) {
                                for (int j = i; j < chars.length; j++) {
                                    chars[j] = ' ';
                                    output = String.valueOf(chars[j]);
                                }
                            }
                            else {
                                for (int j = i; j < chars.length; j++) {
                                    if (chars[j] == a1) {
                                        chars[j] = ' ';
                                        output = String.valueOf(chars[j]);
                                        break;
                                    }
                                    else {
                                        chars[j] = ' ';
                                    }
                                    output = String.valueOf(chars[j]);
                                }
                            }
                        }
                    }
                    output = String.valueOf(chars[i]);

                }




                if (output.contains("/") | output.contains("*")) {
                    sb.append("");
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
