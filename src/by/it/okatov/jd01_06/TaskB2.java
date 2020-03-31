package by.it.okatov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        taskWithoutRegEx(text);

    }

    private static void taskWithoutRegEx(String text) {
        Pattern pattern = Pattern.compile("\\s\\-\\s");
        Matcher m1 = pattern.matcher(text);
        text = m1.replaceAll(" ");
        pattern = Pattern.compile("\\.{3}\\s");
        m1 = pattern.matcher(text);
        text = m1.replaceAll(", ");

        pattern = Pattern.compile("!+");
        m1 = pattern.matcher(text);
        text = m1.replaceAll(".");

        text = text.replaceAll("\n", " ");


        String[] splited = text.split("\\.");
        String regexPattern = "[^А-Яа-яёЁ \\.\\!\\?-]";
        pattern = Pattern.compile(regexPattern);
        for (int i = 0; i < splited.length; i++) {
            Matcher match = pattern.matcher(splited[i]);
            while (match.find()) {
                splited[i] = match.replaceAll("");
            }
        }

        sortingBasedOnLettersCount(splited);
    }


    private static void sortingBasedOnLettersCount(String[] splited) {
        Comparator<String> stringLengthComparator = new StringLengthSort();
        Arrays.sort(splited, stringLengthComparator);
        for (String s : splited) {
            s = s.trim();
            System.out.println(s);
        }
        System.out.println("\n");
    }
}
