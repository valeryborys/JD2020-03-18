package by.it.bobrovich.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    static String[] lines = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text1);
        Pattern pattern = Pattern.compile("((\\d+\\.\\s*)*(|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");
        Matcher matcher = pattern.matcher(text);
        //Pattern pattern1 = Pattern.compile("(^а-яА-ЯёЁ)+");
        while (matcher.find()) {
            String text1 = matcher.group();
            lines = Arrays.copyOf(lines, lines.length + 1);
            lines[lines.length - 1] = text1;
        }
        checkLines(lines);
        sortArray(lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void checkLines(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replaceAll("[^а-яА-ЯёЁ]", " ").replaceAll("   ", " ").replaceAll("  ", " ").trim();
        }

    }

    private static void sortArray(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            int min = i;
            for (int j = i + 1; j < lines.length; j++) {
                if(lines[min].length() > lines[j].length()){
                    min = j;
                }
            }
            String tmp = lines[i];
            lines[i] = lines[min];
            lines[min] = tmp;
        }

    }


}
