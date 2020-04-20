package by.it.borys.jd01_12;

import java.util.*;


public class TaskB1 {
    public static void main(String[] args) {
      String[] words = getWords();
       countWords(words);
        }
    private static void countWords(String[] words){
        List<String> list = Arrays.asList(words);
        Set<String> hs = new HashSet<>(Arrays.asList(words));
        for (String h : hs) {
            int value = 0;
            for (String s : list) {
                if (s.equals(h)) value++;
            }
            System.out.println(h+"="+value);
        }
    }
    private static String[] getWords(){
        Scanner sc = new Scanner(System.in);
        String text;
        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            text = sc.nextLine();
            if (text.equals("end")) {
                break;
            } else sb.append(text);
        }
        text = sb.toString();
        return text.split("[^0-9A-z'-]+");

    }
}
