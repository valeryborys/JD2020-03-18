package by.it.verbitsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        //System.out.println("slow method");
        long startSlow = System.nanoTime();
        System.out.println(slow(Poem.text));
        long stopSlow = System.nanoTime();
        System.out.println((stopSlow - startSlow) / 1000000);
        //System.out.println("\nFast method");
        long startFast = System.nanoTime();
        System.out.println(fast(Poem.text));
        long stoptFast = System.nanoTime();
        System.out.println((stoptFast - startFast) / 1000000);

    }

    private static String slow(String text) {
        String str = "";
        Pattern patternSentence = Pattern.compile("\n");
        Matcher matcher = patternSentence.matcher(text);
        text = matcher.replaceAll(" ");
        String[] words = text.split("[^а-яА-ЯёЁ]");
        while (str.length() < 100000) {
            for (String word : words) {
                str = str.concat(word).concat(" ");
            }
        }
        return str;

    }

    private static String fast(String text) {
        StringBuilder str = new StringBuilder();
        Pattern patternSentence = Pattern.compile("\n");
        Matcher matcher = patternSentence.matcher(text);
        text = matcher.replaceAll(" ");
        String[] words = text.split("[^а-яА-ЯёЁ]");
        while (str.length() < 100000) {
            for (String word : words) {
                str.append(word).append(" ");
            }
        }
        return String.valueOf(str);
    }
}
