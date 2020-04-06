package by.it.bobrovich.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        String text = Poem.text;
        long slow1 = System.nanoTime();
        slow(text);
        System.out.println(slow1);
        long fast1 = System.nanoTime();
        fast(text);
        System.out.println(fast1);
    }

    private static String slow(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String line = "";
        while (line.length() < 100000) {
            for (String word : words) {
                line = line.concat(word + " ");
            }
        }
        return line;
    }

    private static String fast(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder line = new StringBuilder("");
        while (line.length() < 100000){
            for (String word : words) {
                line = line.append(word).append(" ");
            }
        }

        return line.toString();
    }
}
