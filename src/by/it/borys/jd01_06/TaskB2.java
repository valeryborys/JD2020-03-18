package by.it.borys.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replaceAll("\\.\\.\\.", "&");
        String[] poem = text.split("\\.");
        for (int i = 0; i < poem.length; i++) {
            StringBuilder sb = new StringBuilder(poem[i]);
            Pattern p1 = Pattern.compile("\\s*[^а-яА-ЯёЁ]\\s*");
            Matcher m1 = p1.matcher(sb);
            int pos = 0;
            while (m1.find(pos)) {
                int start = m1.start();
                int end = m1.end();
                sb.replace(start, end, " ");
                pos = start + 1;
            }
            poem[i] = sb.toString();
            poem[i] = poem[i].trim();

        }
        int i = 1;
        String temp;
        while (i < poem.length) {
            if (i == 0 || poem[i - 1].length() <= poem[i].length()) {
                i++;
            } else {
                temp = poem[i];
                poem[i] = poem[i - 1];
                poem[i - 1] = temp;
                i--;
            }
        }
        for (int i1 = 0; i1 < poem.length; i1++) {
            System.out.println(poem[i1]);
        }
    }

}