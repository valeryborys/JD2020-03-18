package by.it.bobrovich.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("((\\d+\\.\\s*)*(|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");
        Matcher matcher = pattern.matcher(text);
        Pattern pattern1 = Pattern.compile("[^а-яА-ЯёЁ]");
        while (matcher.find()) {
            StringBuilder text1 = new StringBuilder(matcher.group());
            Matcher matcher1 = pattern1.matcher(text1);
            while (matcher1.find()) {
                int position = matcher1.start();
                text1.setCharAt(position, ' ');
            }
            //String s = text1.toString();
            System.out.println(text1);
            System.out.println();
        }
    }
}
