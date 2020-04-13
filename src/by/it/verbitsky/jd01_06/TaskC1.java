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
        StringBuilder buf = new StringBuilder(text);
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(buf);
        boolean maxLength = false;
        boolean findFlag;
        while (buf.length() != sLength) {
            findFlag = matcher.find();
            if (findFlag) {
                while (findFlag) {
                    buf.insert(matcher.start(), ' ');
                    findFlag = matcher.find(matcher.end() + 1);
                    if (buf.length() == sLength) {
                        maxLength = true;
                        break;
                    }
                }
            } else {
                matcher.reset();
            }
            if (maxLength) {
                break;
            } else {
                matcher.reset();
            }
        }
        return String.valueOf(buf);
    }
}
