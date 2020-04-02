package by.it.borys.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
   public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p0 = Pattern.compile("\\.\\.\\.");
        Matcher m0 = p0.matcher(sb);
        m0.find();
           int threepoints = m0.start();
        int threepointsend = m0.end();
        sb.replace(threepoints,threepointsend,"&");

        Pattern p1 = Pattern.compile("\\s*+[^а-яА-яёЁ\\.]+\\s*");
        Matcher m1 = p1.matcher(sb);
        int pos=0;
        while (m1.find(pos)){
            int start = m1.start();
            int end = m1.end();
            sb.replace(start,end," ");
            pos=start+1;
        }

        System.out.println(sb);
    }
}
