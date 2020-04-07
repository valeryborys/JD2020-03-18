package by.it.lemesh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[\\n]+");
        Pattern p = Pattern.compile("[ ]");
        String[] sents = pattern.split(text);
        String[] newSents = new String[sents.length];
        int max = 0;
        for (int i = 0; i < sents.length; i++) {
            if (sents[i].length() > max) {
                max = sents[i].length();
            }
        }
        for (int i = 0; i < sents.length; i++) {
            Matcher m = p.matcher(sents[i]);
            StringBuilder sb = new StringBuilder(sents[i]);
            int add = max - sents[i].length();
            int count = 0;
            int k = 1;
            int j = 0;
            int countPos = 0;
            while (count < add) {
                if (m.find()) {
                    int pos = m.start();
                    countPos = k * j;
                    sb.insert(pos + countPos, ' ');
                    j++;
                    count++;
                } else {
                    j = 0;
                    k++;
                    m.reset();
                }
            }
            newSents[i] = sb.toString();
        }
        for (int i = 0; i < sents.length; i++) {
            System.out.print(newSents[i] + "\n");
        }
    }
}
