package by.it.okatov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {

        StringBuilder text = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{4,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int position = matcher.start();
            text.setCharAt(position + 3, '#');

            if (matcher.end() - matcher.start() >= 7) {
                text.setCharAt(position + 6, '#');
            }

        }

        System.out.println(text);
    }

}
