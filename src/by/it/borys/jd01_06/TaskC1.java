package by.it.borys.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] text = Poem.text.split("\n");
        String longest = new String();
        for (String el : text) {
            if (el.length() > longest.length()) {
                longest = el;
            }
        }
        for (String el : text) {
            StringBuilder string = new StringBuilder(el);
            System.out.println(spaceAdd(string, longest.length()));
        }
      }

    static String spaceAdd(StringBuilder string, int lenth) {
        int i = 1;
        while (string.length() < lenth) {
            String regexp = "\\s{" + i + "}";
            Pattern p1 = Pattern.compile(regexp);
            Matcher m1 = p1.matcher(string);
            int pos = 0;
            while (m1.find(pos) && string.length() < lenth) {
                int start = m1.start();
                int end = m1.end();
                StringBuilder regexp2 = new StringBuilder(" ");
                for (int j = 0; j < i; j++) {
                    regexp2 = regexp2.append(" ");
                }
                String spaces = regexp2.toString();
                string.replace(start, end, spaces);
                pos = end + 1;
            }
            i++;
        }
        return string.toString();
    }
}