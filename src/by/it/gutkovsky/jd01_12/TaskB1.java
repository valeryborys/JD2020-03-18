package by.it.gutkovsky.jd01_12;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> countMap = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        while (true) {
            String word = sc.next();
            if (word.equals("end")) {
                break;
            }
            StringBuilder sb = new StringBuilder(word);
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                String checkWord = matcher.group();
                if (countMap.containsKey(checkWord)) {

                    for (Map.Entry<String, Integer> pair : countMap.entrySet()) {
                        if (pair.getKey().equals(checkWord)) {
                            pair.setValue(pair.getValue() + 1);
                        }
                    }
                } else {
                    countMap.put(checkWord, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> pair : countMap.entrySet()) {
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.printf("%s=%s\n", key, value);
        }

    }

}
