package by.it.lemesh.jd01_14;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String fileName = getDir(TaskB.class, "text.txt");
        String line = getString(fileName);
        int words = wordsCount(line);
        int marks = marksCount(line);
        System.out.println("words=" + words + ", punctuation marks=" + marks);
        fileName = getDir(TaskB.class, "resultTaskB.txt");
        writeTxt(fileName, words, marks);
    }

    private static String getDir(Class<?> cl, String name) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return root + path + name;
    }

    private static String getString(String fileName) {
        String line = "";
        try (FileReader reader = new FileReader(fileName)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                line = line + sc.nextLine() + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.replace("...", ".");
    }

    private static int wordsCount(String line) {
        Pattern p = Pattern.compile("[;!—//., -]+");
        String[] words = p.split(line);
        return words.length;
    }

    private static int marksCount(String line) {
        int count = 0;
        Pattern p = Pattern.compile("[.,:!-]");
        Matcher m = p.matcher(line);
        while (m.find()) count++;
        return count;
    }

    private static void writeTxt(String fileName, int words, int marks) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print("words=" + words + ", punctuation marks=" + marks);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}