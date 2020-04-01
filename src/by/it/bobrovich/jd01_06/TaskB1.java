package by.it.bobrovich.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static char[] vowels = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е', 'А', 'У', 'О', 'Ы', 'И', 'Э', 'Я', 'Ю', 'Ё', 'Е'};
    static String[] words = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > 1) check(word);
        }
        System.out.println(words.length);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void check(String word) {
        char[] chars = word.toCharArray();
        if (equalCons(chars)) {
            if (equalVowels(chars)) {
                words = Arrays.copyOf(words, words.length + 1);
                words[words.length - 1] = word;
            }
        }
    }

    private static boolean equalCons(char[] chars) {
        for (char vowel : vowels) {
            if (chars[0] == vowel) {
                return false;
            }
        }

        return true;
    }

    private static boolean equalVowels(char[] chars) {
        for (char vowel : vowels) {
            if (chars[chars.length - 1] == vowel) {
                return true;
            }
        }
        return false;
    }
}
