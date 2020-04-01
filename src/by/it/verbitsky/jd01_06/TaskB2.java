package by.it.verbitsky.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;

        Pattern patternSentence = Pattern.compile("\n");
        Matcher matcher = patternSentence.matcher(text);
        text = matcher.replaceAll(" ");
        //Убираем многоточия
        patternSentence = Pattern.compile("(\\.{2,})");
        matcher = patternSentence.matcher(text);
        text = matcher.replaceAll("");
        //регулярка для разделения на предложения - получаем массив, разделив строку через . ! или ?
        String[] sentences = text.split("[.!?]{1}");
        //заменяем небуквенные символы на пробелы и "тримаем" строку
        patternSentence = Pattern.compile("[\\p{Punct} ]+");
        for (int i = 0; i < sentences.length; i++) {
            matcher = patternSentence.matcher(sentences[i]);
            sentences[i] = matcher.replaceAll(" ").trim(); //обрезаем пробелы в начале и в конце
        }
/*
        System.out.println("\nДо сортировки:");
        for (int i = 0; i < sentences.length; i++) {
            String elem = sentences[i];
            System.out.print(elem + "\n");
        }

 */
        //сортировать массив можно обычным циклом For сравнивая длины строк в элементах массива
        //для удобства написал сортировку использующую компаратор (шаблон для сравнения)
        sortStringArray(sentences);
        //System.out.println("\nПосле сортировки");
        for (String elem : sentences) {
            System.out.print(elem + "\n");
        }
    }

    private static void sortStringArray(String[] sentences) {
        Comparator<String> comparator = new StringLengthComparator();
        Arrays.sort(sentences, comparator);
    }
}
