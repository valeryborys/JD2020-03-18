package by.it.novikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class TaskA1 {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder(Poem.text);
            Pattern pt = Pattern.compile("[а-яА-ЯёЁ]{4,}");
            Matcher mt = pt.matcher(Poem.text);
            while (mt.find())
            {
                int start = mt.start();
                sb.setCharAt(start+3, '#');
                if (mt.group().length()>=7) {
                    sb.setCharAt(start+6, '#');
                }
            }
            System.out.println(sb);



        }
    }


