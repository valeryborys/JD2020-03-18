package by.it.bobrovich.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Scanner sc = new Scanner(System.in);
        String line;
        Map<String, Integer> words = new HashMap<>();
        while(!(line = sc.next()).equals("end")){
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                line = matcher.group();
            }
            if(line.equals("isn't"))
                line = "don't";
            Integer count = 0;
            if(words.get(line) == null){
                words.put(line, ++count);
            }else{
                count = words.get(line);
                words.replace(line, ++count);
            }
        }
        System.out.println(words);
    }
}
