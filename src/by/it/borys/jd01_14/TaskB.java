package by.it.borys.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        inputToString(sb);
        int countwords = 0;
        int countmarks = 0;
        Pattern p1 = Pattern.compile("[А-яЁёA-z]+");
        Pattern p2 = Pattern.compile("[^А-яЁёA-z\\s0-9]+");
        Matcher m1 = p1.matcher(sb);
        Matcher m2 = p2.matcher(sb);
        while (m1.find()) {
            countwords++;
        }
        while (m2.find()) {
            countmarks++;
        }
        String res = "words=" + countwords + ", punctuation marks=" + countmarks;
        System.out.println(res);
        printToTxt(res);

    }

    private static void inputToString(StringBuilder sb) {
        try (DataInputStream input = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(TaskA.dir(TaskB.class) + "text.txt")))
            ) {
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            int b = 0;
            while ((b = isr.read()) != -1) {
                sb.append((char) b);
              }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToTxt(String res) {
        try(PrintWriter out = new PrintWriter(TaskA.dir(TaskB.class)+"resultTaskB.txt")){
            out.print(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
  }