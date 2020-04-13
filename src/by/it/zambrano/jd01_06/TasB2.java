package by.it.zambrano.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TasB2 {
    static class TaskB2 {
        public static void main(String[] args) {
            String a = Poem.text;
            String b = a.replaceAll("\n", " ");
            StringBuilder text = new StringBuilder(b);
            Pattern firststage = Pattern.compile("[\\.]{3}");
            Matcher matcher = firststage.matcher(text);
            while (matcher.find()) {
                int start = matcher.start();
                text.setCharAt(start, ' ');
                text.setCharAt(start + 1, ' ');
                text.setCharAt(start + 2, ' ');
            }
            Pattern secondstage = Pattern.compile("\\,+");
            Matcher matcher2 = secondstage.matcher(text);
            while (matcher2.find()) {
                int start = matcher2.start();
                text.setCharAt(start, ' ');
            }
            Pattern thirdstage = Pattern.compile("\\-+");
            Matcher matcher3 = thirdstage.matcher(text);
            while (matcher3.find()) {
                int start = matcher3.start();
                text.setCharAt(start, ' ');
            }
            Pattern fourthstage = Pattern.compile("\\:+");
            Matcher matcher4 = fourthstage.matcher(text);
            while (matcher4.find()) {
                int start = matcher4.start();
                text.setCharAt(start, ' ');
            }
            Pattern pattern = Pattern.compile("[\\.\\!]+");

            String c = text.toString().replaceAll("[\\s]{2,}", " ");
            String[] arr = pattern.split(c);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j].length() > arr[j + 1].length()) {
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].trim());
            }


        }
    }
}