package by.it.zambrano.jd01_06;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static char[] vowels = {'а', 'А', 'у', 'У', 'о', 'О', 'ы', 'Ы', 'и', 'И', 'э', 'Э', 'я', 'Я', 'ю', 'Ю', 'ё', 'Ё', 'е', 'Е'};
    static String[] wordsconsonantvowel = {};


    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > 1) verification(word);
        }
        for (String word : wordsconsonantvowel) {
            System.out.println(word);
        }
    }

    private static void verification(String word) {
        char[] chars = word.toCharArray();
        if (lastvowel(chars) && firstconsonant(chars)) {
            wordsconsonantvowel = Arrays.copyOf(wordsconsonantvowel, wordsconsonantvowel.length + 1);
            wordsconsonantvowel[wordsconsonantvowel.length - 1] = word;
        }
    }

    private static boolean lastvowel(char[] chars) {
        for (char vowel : vowels) {
            if (chars[chars.length-1] == vowel) {
                return true;
            }
        }
        return false;
    }

    private static boolean firstconsonant(char[] chars) {
        for (char vowel : vowels) {
            if (chars[0] == vowel) {
                return false;
            }
        }
        return true;
    }
}