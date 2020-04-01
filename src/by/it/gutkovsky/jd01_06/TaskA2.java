package by.it.gutkovsky.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA2 {

    private static String[] words = {};
    private static int[] count = {};

    private static int getPosiyion(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            int position = getPosiyion(word);
            if (position >= 0) {
                count[position]++;
            } else {
                int lastElement = words.length;
                words = Arrays.copyOf(words, lastElement + 1);
                words[lastElement] = word;
                count = Arrays.copyOf(count, lastElement + 1);
                count[lastElement] = 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + count[i]);
        }


    }
}
