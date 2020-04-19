package by.it.gutkovsky.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {
    public static void main(String[] args) {
        String file = getFileName(TaskB.class, "text.txt");
        File f = new File(file);
        List<String> listOfWords = new ArrayList<>();
        readWordsFromFile(listOfWords, f);
        String text = getText(f);
        List<String> listOfMarks = new ArrayList<>();
        readMarks(text, listOfMarks);
        printToConsole(listOfWords, listOfMarks);
        printToFile(TaskB.class,"resultTaskB.txt", listOfWords, listOfMarks);
    }

    private static void printToFile(Class<?> aClass, String fileSimpleName, List<String> listOfWords, List<String> listOfMarks) {
        String fileToPrint =getFileName(aClass, fileSimpleName);
        try (PrintWriter out = new PrintWriter(fileToPrint)){
            out.print(" words="+listOfWords.size()+", punctuation marks="+(listOfMarks.size()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<String> listOfWords, List<String> listOfMarks) {
        System.out.println(" words="+listOfWords.size()+", punctuation marks="+listOfMarks.size());
    }

    private static void readMarks(String text, List<String> listOfMarks) {
        Pattern pattern = Pattern.compile("[^(а-яА-ЯёЁ)+\\s]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            listOfMarks.add(matcher.group());
        }
    }

    private static String getText(File f) {
        StringBuilder sb = new StringBuilder();
        int symbol;
        String text = null;

        try (FileReader fr = new FileReader(f)) {
            while ( (symbol = fr.read()) != -1){
                sb.append((char)symbol);
            }
            text = sb.toString().replace("...",".");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private static void readWordsFromFile(List<String> listOfWords, File f) {
        try (Scanner sc = new Scanner(f)) {
            sc.useDelimiter("\\s+(-\\s)?");
            while (sc.hasNext()) {
                listOfWords.add(sc.next());
            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }
}
