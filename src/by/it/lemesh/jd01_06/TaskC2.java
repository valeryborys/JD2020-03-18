package by.it.lemesh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long t1Slow = System.nanoTime();
        String text = slow(Poem.text);
        long t2Slow = (System.nanoTime() - t1Slow)/1000000;
        System.out.println("Медленный метод = " + t2Slow + " милисек");


        long t1Fast = System.nanoTime();
        String text2 = fast(Poem.text);
        long t2Fast = (System.nanoTime() - t1Fast)/1000000;
        System.out.println("Медленный метод = " + t2Fast + " милисек");
        System.out.println("Разница в " + t2Slow/t2Fast + " раз");


    }


    private static String slow(String text) {
        String[] splitText = text.split(" ");
        String newText = new String();
        for (int i = 0; i < 300; i++) {
            for (int j = splitText.length - 1; j > 0; j--) {
                newText = newText.concat(splitText[j]) + " ";
            }
        }
        return newText;
    }

    private static String fast(String text) {
        String[] splitText = text.split(" ");
        String newText = new String();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            for (int j = splitText.length - 1; j > 0; j--) {
                sb = sb.append(splitText[j] + " ");
            }
        }
        return sb.toString();
    }

}
