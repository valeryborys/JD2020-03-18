package by.it.gutkovsky.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> mapC = new TreeMap<>();
        Integer key = 1;
        Pattern pattern = Pattern.compile("[a-zA-Z']+");

        while (true) {
            String word = sc.next();
            if (word.equals("end")) {
                break;
            }
            StringBuilder sb = new StringBuilder(word);
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                mapC.put(key, word);
                key++;
            }
        }
        System.out.println(mapC.toString());
        System.out.println();
        System.out.println(squeezeMap(mapC).toString());
    }

    private static Map<Integer, String> squeezeMap(Map<Integer, String> inputMap) {
        Map<Integer, String> squeezedMap = new TreeMap<>();
        for (Map.Entry<Integer, String> inputElements : inputMap.entrySet()) {
            if (!squeezedMap.containsValue(inputElements.getValue())) {
                squeezedMap.put(inputElements.getKey(), inputElements.getValue());
            }
        }
        return squeezedMap;
    }

}
