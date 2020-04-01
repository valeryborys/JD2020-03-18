package by.it.verbitsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        //строка для эксперементов (исходник)
        StringBuilder sBuilder = new StringBuilder(Poem.text);
        //создаем паттер который содержит регулярку по которой будем искать
        //такой шаблон соответствуеет отбору всех русских слов
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        //матчер является как бы "поисковиком" по заданному в патерне шаблону
        Matcher matcher = pattern.matcher(sBuilder);

        while (matcher.find()) {
            //когда метод find вернет истину matcher.start() будет указывать на номер позиции
            //в которой встречается текст, соответствующий шаблону
            //добавим 3 чтобы заменять каждый 4-й символ на #
            sBuilder.setCharAt(matcher.start()+3, '#');
            //проверяем, если длина возвращенного слова больше 7 меняем и 7-й символ также
            if (matcher.end()-matcher.start() >= 7) {
                sBuilder.setCharAt(matcher.start()+6, '#');
            }
        }
        System.out.println(sBuilder);
    }
}
