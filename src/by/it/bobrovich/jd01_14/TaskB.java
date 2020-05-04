package by.it.bobrovich.jd01_14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static final String patternWords = "[а-яА-ЯёЁ]+";
    private static final String patternSymbols = "[^ а-яА-ЯёЁ]+";

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clPath;
    }

    public static void main(String[] args) {
        System.out.println(dir(TaskB.class) + "text.txt");
        List<String> text = new ArrayList<>();
        try(PrintWriter pw = new PrintWriter(new FileWriter(dir(TaskB.class)+"resultTaskB.txt"));) {
            text = Files.readAllLines(Paths.get(dir(TaskB.class) + "text.txt"));
            System.out.print("words=" + count(text, patternWords) + ", ");
            System.out.println("punctuation marks=" + count(text, patternSymbols));
            pw.print("words=" + count(text, patternWords) + ", " + "punctuation marks=" + count(text, patternSymbols));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int count(List<String> text, String pattern1){
        int count = 0;
        StringBuilder sb = new StringBuilder(text.toString());
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(sb);
        while(matcher.find()){
            count+=1;
        }
        return count;
    }
}
