package by.it.bobrovich.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ, -:\n]+");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String text1 = matcher.group();
            System.out.println(text1);
        }
    }
}
