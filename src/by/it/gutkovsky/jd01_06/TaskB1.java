package by.it.gutkovsky.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    private static String[] wordsArray = {};
    private static char[] vowels = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е', 'А', 'У', 'О', 'И', 'Э', 'Я', 'Ю', 'Ё', 'Е'};
    private static char[] consonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            checkWord(word);
        }
        for (String s : wordsArray) {
            System.out.println(s);
        }
    }

    private static void checkWord(String word) {
        char[] checkWord = word.toCharArray();
        boolean startOfWord = false;
        boolean endOfWord = false;
        for (char consonant : consonants) {
            if (consonant == checkWord[0]) {
                startOfWord = true;
                break;
            }
        }
        for (char vowel : vowels) {
            if (vowel == checkWord[checkWord.length - 1]) {
                endOfWord = true;
                break;
            }
        }

        if (startOfWord && endOfWord) {
            int lastElement = wordsArray.length;
            wordsArray = Arrays.copyOf(wordsArray, lastElement + 1);
            wordsArray[lastElement] = word;
        }

    }
}
