package by.it.okatov.jd01_12;


import java.util.*;
import java.util.stream.Stream;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = ""; //Переменная для хранения входа с консоли
        //Каждый элемент коллекции - слово из текста без знаков препинания и пробелов
        Collection<String> col = new ArrayList<>();
        //Нужна для хранения и вывода количества вхождений каждого слова в тексте
        Map<String, Integer> map = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        String word;
        boolean isPresent;

        while (true) {
            if (input.endsWith("end")) {
                break;
            }
            input += " " + sc.nextLine();
        }

        System.out.println(input);

        input = input.replaceAll("[,:;.!?/\\-\\n]", " ");
        System.out.println(input);
        String[] sArr = input.split(" ");
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
