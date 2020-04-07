package by.it.szamostyanin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] count = new int[0];

    private static void position(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                count[i] = count[i] + 1;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        count = Arrays.copyOf(count, count.length + 1);
        count[count.length - 1] = 1;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            position(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + count[i]);
        }
    }
}

