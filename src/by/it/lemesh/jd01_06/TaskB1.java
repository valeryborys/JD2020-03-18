package by.it.lemesh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        boolean b;
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            b = chekWord(word);
            if (b) {
                System.out.println(word + " ");
            }
        }
    }

    private static boolean chekWord(String word) {
        boolean flag1 = false;
        boolean flag2 = false;
        String vow = "аАеЕёЁиИоОуУыЫэЭюЮяЯ";
        String cons = "бБвВгГдДжЖзЗкйЙКлЛмМнНпПрРсСтТфФхХцЦчЧшШщЩьъ";
        for (int i = 0; i < vow.length(); i++) {
            if (vow.charAt(i) == word.charAt(word.length() - 1)) {
                flag2 = true;
            }
        }
        for (int j = 0; j < cons.length(); j++) {
            if (cons.charAt(j) == word.charAt(0)) {
                flag1 = true;
            }
        }
        return (flag1) & (flag2);
    }
}
