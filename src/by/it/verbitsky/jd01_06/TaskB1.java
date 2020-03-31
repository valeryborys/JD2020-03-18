package by.it.verbitsky.jd01_06;

import java.util.Arrays;

public class TaskB1 {
    private static char[] vowels = {'Ё', 'А', 'Е', 'И', 'О', 'У', 'Э', 'Ю', 'Я', 'а', 'е', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'ё'};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                while (Character.isLetter(text.charAt(i))) {
                    word.append(text.charAt(i));
                    i++;
                }
                word.trimToSize();
                if (word.length() > 2) {
                    checkWord(word);
                }
                word.setLength(0);
            }
        }
    }

    private static void checkWord(StringBuilder word) {
        if (Arrays.binarySearch(vowels, word.charAt(0)) < 0) {
            if (Arrays.binarySearch(vowels, word.charAt(word.length() - 1)) > -1) {
                System.out.println(word);
            }
        }
    }

}
