package by.it.verbitsky.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[]{};
    private static int[] wordCounts = new int[]{};

    public static void main(String[] args) {
        //паттерн соответствует любому русскому слову
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            calcWords(matcher.group());
        }
        System.out.println("count= " + wordCounts.length);
        printWords(words, wordCounts);
    }

    private static void calcWords(String str) {
        for (int i = 0; i < words.length; i++) {
            //сразу проверим, есть ли уже искомое слово в массиве
            // если да увеличим соответствующий элемент массива с кол-вом на 1ж
            if (words[i].equals(str)) {
                wordCounts[i] += 1;
                return;
            }
            //если слова не нашлось, то "добавляем его в массивы":
            //строку в вордс, кол-во в каунтс
            //для этого пересоздаем массивы, увеличив размерность на 1
            //после копирования дописываем в конец слово и кол-во
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = str;
        wordCounts = Arrays.copyOf(wordCounts, wordCounts.length + 1);
        wordCounts[wordCounts.length - 1] = 1;

    }

    private static void printWords(String[] words, int[] wordCounts) {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], wordCounts[i]);
        }
    }
}
