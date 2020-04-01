package by.it.szamostyanin.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]{4,}";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(sb);
        while (matcher.find()){
            sb.setCharAt(matcher.start()+3,'#');
            if (matcher.end()-matcher.start() >=7){
                sb.setCharAt(matcher.start()+6,'#');
            }
        }
        System.out.println(sb);
    }
}