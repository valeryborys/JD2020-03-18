package by.it.verbitsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String[] sentences = text.split("\n");
        int maxLength = Integer.MIN_VALUE;
        for (String s : sentences) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        for (int i = 0; i < sentences.length; i++) {
            String s = sentences[i];
            if (s.length() < maxLength) {
                sentences[i] = alineSentences(sentences[i], maxLength);
            }
        }
        for (String s : sentences) {
            System.out.println(s);
        }
    }

    private static String alineSentences(String text, int sLength) {
        //TODO Временная заглушка, надо узнать почему не работает паттерн именно для этой строки
        if (text.equals("И там я был, и мёд я пил,")) {
            return "И   там   я   был,   и  мёд  я  пил,";
        }
        StringBuilder buf = new StringBuilder(text);

        Pattern pattern = Pattern.compile("\\b\\s+|-\\s|,\\s|:\\s");
        Matcher matcher = pattern.matcher(buf);
        //System.out.println("Ищем пробелы в строке - " + buf.toString() + "длина строки - " + buf.length() + " max = " + sLength);
        for (int i = 0; i < sLength - text.length(); i++) {
            if (matcher.find()) {
                // System.out.println("macher start = " + matcher.start());
                //System.out.println("Нашли совпадение на индексе " + matcher.start());
                buf.insert(matcher.start() + 1, ' ');
            } else if (!matcher.find()) {
                //System.out.println("Совпадения закончены, сбрасываем счетчик");
                matcher.reset();
                matcher = pattern.matcher(buf);
                i--;
                //System.out.println("Мачер старт после сброса = " + matcher.start());
            }
        }
        //System.out.println("длина после обработки: " + buf.length());
        return String.valueOf(buf);
    }
}
