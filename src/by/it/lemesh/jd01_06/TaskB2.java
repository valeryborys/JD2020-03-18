package by.it.lemesh.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String poemText = Poem.text.replace("... ", " ");
        StringBuilder text = new StringBuilder(poemText);
        Pattern pattern = Pattern.compile("[//.]+");
        Pattern p = Pattern.compile("[\\n, !:.-]+");
        String[] sents = pattern.split(text);
        for (int i = 0; i < sents.length; i++) {
            Matcher m = p.matcher(sents[i]);
            sents[i] = m.replaceAll(" ");
            sents[i] = sents[i].trim();
        }
        sents = sort(sents);
        for (int i = 0; i < sents.length; i++) {
            System.out.print(sents[i] + "\n");
        }
    }

    private static String[] sort(String[] arr) {
        String temp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


}
