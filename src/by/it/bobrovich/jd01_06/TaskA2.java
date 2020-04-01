package by.it.bobrovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    static String[] words = {};
    static int[] count = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            check(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n",words[i],count[i]);
        }

    }

    private static void check(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                count[i] += 1;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        count = Arrays.copyOf(count, count.length + 1);
        words[words.length - 1] = word;
        count[count.length - 1] = 1;

    }
}
