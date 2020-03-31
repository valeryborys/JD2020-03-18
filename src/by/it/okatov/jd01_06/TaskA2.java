package by.it.okatov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = {};
    private static int[] counts = {};


    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }


        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], counts[i]);
        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counts[i]++;
                break;
            }
        }

        words = Arrays.copyOf(words, words.length + 1);
        counts = Arrays.copyOf(counts, counts.length + 1);
        words[words.length - 1] = word;
        counts[counts.length - 1] = 1;
    }
}
