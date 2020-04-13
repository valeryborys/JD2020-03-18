package by.it.okatov.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = ""; //Переменная для хранения входа с консоли
        //Каждый элемент коллекции - слово из текста без знаков препинания и пробелов
        Collection<String> col = new ArrayList<>();
        //Нужна для хранения и вывода количества вхождений каждого слова в тексте
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\bend\\b)");
        Matcher m1;
        HashSet<String> hs = new HashSet<>();
        String word;
        String tmp = "";
        boolean isPresent;

        while (true) {
            if (input.endsWith("end")) {
                break;
            }
            input += " " + sc.nextLine();
        }

        System.out.println(input);
        tmp = input;
        tmp = tmp.replaceAll("[,:;.!?/\\-\\n]", " ");
        System.out.println(tmp);
        String[] sArr = tmp.split(" ");
        for (String s : sArr) {
            s = s.trim();
            col.add(s);
        }
        System.out.println(col);
        Iterator<String> iterator = col.iterator();
        while (iterator.hasNext()) {
            word = iterator.next();
            if (word.equals("")) {
                iterator.remove();
            } else {
                isPresent = hs.add(word);
                if (isPresent)//Если это первое вхождение слова
                {
                    map.put(word, 1);//Заносим его в ХэшМап
                } else {
                    //Находим совпадающий ключ и увеличиваем соответствующее ему значение на единицу
                    map.put(word, map.get(word) + 1);
                }
            }
        }

        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
        stream.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }
}
