package by.it.novikov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String word;
        StringBuilder text;
        while (!(word = sc.next()).equals("end")) {
            word = word.trim().replaceAll("[-—\\(\\)!:;\\.,\\?/\\s\"]+", "");
            if (word.equals("isn't")){
                word = "don't";
            }
            if (!words.containsKey(word)) {
                words.put(word, 1);
            } else {
                int val = words.get(word);
                words.put(word, ++val);
            }
        }
        for (Map.Entry<String, Integer> item : words.entrySet()) {
            System.out.println(item.getKey() + "=" + item.getValue());
        }
    }
}