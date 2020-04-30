package by.it.novikov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {
    public static void main(String[] args) {
        String textFile = getPath("text.txt");
        String textFromFile = readText(textFile);
        int countWords = getCountWords(textFromFile);
        int punctMarks = getPunctMarks(textFromFile);
        String result = "words=" + countWords + ", punctuation marks=" + punctMarks;
        System.out.println(result);
        writeToFile(result);
    }

    private static void writeToFile(String text) {
        File file = new File(getPath("resultTaskB.txt"));
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getPunctMarks(String text) {
        int count = 0;
        text = text.replaceAll("\\.\\.\\.", ",");
        Pattern pattern = Pattern.compile("[-!:,.]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static int getCountWords(String text) {
        int count = 0;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    static String getPath(String fileName) {
        String name = TaskB.class.getName();
        String path = name
                .replace(TaskB.class.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + path + fileName;
        return path;
    }

    private static String readText(String fileName) {
        StringBuilder sb = new StringBuilder();
        int c;
        File file = new File(fileName);
        try (FileReader fr = new FileReader(file)) {
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}