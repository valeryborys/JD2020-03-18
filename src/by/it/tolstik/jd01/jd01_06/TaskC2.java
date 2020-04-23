package by.it.tolstik.jd01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long startSlow = System.nanoTime();
        slow(Poem.text);
        long stopSlow = System.nanoTime();
        System.out.println((stopSlow - startSlow) / 1000000);
        long startFast = System.nanoTime();
        fast(Poem.text);
        long stopFast = System.nanoTime();
        System.out.println((stopFast - startFast) / 1000000);

    }

    private static String slow(String text) {
        String str = "";
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");
        while (str.length() < 100000) {
            str = str.concat(text).concat(" ");
        }
        return str;

    }

    private static String fast(String text) {
        StringBuilder str = new StringBuilder();
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");
        while (str.length() < 100000) {
            str.append(text).append(" ");
        }
        return String.valueOf(str);
    }
}