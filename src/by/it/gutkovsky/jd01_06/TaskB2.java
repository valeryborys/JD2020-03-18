package by.it.gutkovsky.jd01_06;

import javafx.beans.binding.When;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {
    public static void main(String[] args) {
        String[] sentence = {};
        sentence = Poem.text.split("!?\\.\\??");

        String[] newLine = new String[sentence.length];

        Pattern pattern = Pattern.compile("[\\n\\p{P}]"); // не букенные символы  \n - меняю на пробел

        for (int i = 0; i < sentence.length; i++) {
            StringBuilder poemLine = new StringBuilder(sentence[i]);
            Matcher matcher = pattern.matcher(poemLine);
            while (matcher.find()) {
//                newLine[i]= matcher.replaceAll("");
                int position = matcher.start();
                poemLine.replace(position, position + 1, " ");
            }
            newLine[i] = String.valueOf(poemLine);
        }

        // проверка вывода на печать
//        for (int i = 0; i < newLine.length; i++) {
//            System.out.println(i + ":" + newLine[i]);
//        }

        // trim() - начало и конца строки
        for (int i = 0; i < newLine.length; i++) {
            sentence[i] = newLine[i].trim();
        }

        // проверка вывода на печать
//        for (int i = 0; i < sentence.length; i++) {
//            System.out.println(i + ":" + sentence[i]);
//        }

        // удаление лишних пробелов
        for (int i = 0; i < sentence.length; i++) {
            StringBuilder nextIteration = new StringBuilder(sentence[i]);
            Pattern pattern2 = Pattern.compile("[\\s\\-\\s]{2,}");
            Matcher matcher2 = pattern2.matcher(nextIteration);
            sentence[i] = matcher2.replaceAll(" ");
        }

        String temp = null;
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            for (int i = 0; i < sentence.length - 1; i++) {
                if (sentence[i].length() > sentence[i + 1].length()) {
                    temp = sentence[i];
                    sentence[i] = sentence[i + 1];
                    sentence[i + 1] = temp;
                    needSort = true;
                }
            }
        }

        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i].length() != 0) {
                System.out.printf("%s\n", sentence[i]);
            }
        }


    }


}
