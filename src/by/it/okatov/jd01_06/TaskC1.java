package by.it.okatov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        String text = Poem.text;
        String[] splited = text.split("\n");
        String sBig = sortingBasedOnLettersCount(splited);
        Pattern pattern = Pattern.compile("\\s");
        Matcher m1;
        for (String s : splited) {
            System.out.println(s);
        }
        System.out.println("\n\n");

        for (String s : splited) {
            s = addSpaces(s, sBig.length());
            System.out.println(s);
        }

    }

    private static String addSpaces(String s, int count) {
        //Проверка от бесконечного цикла
        if (s.indexOf(DELIMITER) == -1) {
            return null;
        }

        final StringBuilder sb = new StringBuilder(s); //Рабочий буфер
        int delimiterPointer = 0; //Указатель на пробел

        while (sb.length() < count) {
            int index = sb.indexOf(DELIMITER, delimiterPointer);


            //Если конец текущей строки
            if (index == -1) {
                delimiterPointer = 0;
                continue;
            }

            delimiterPointer = index + DELIMITER.length();

            //Проверка является ли этот пробел последним.
            if (delimiterPointer == sb.indexOf(DELIMITER, delimiterPointer)) {
                continue;
            }

            sb.replace(delimiterPointer, delimiterPointer, DELIMITER);
            delimiterPointer += DELIMITER.length();
        }

        return sb.toString();

    }

    private static String sortingBasedOnLettersCount(String[] sArr) {
        String[] splited = Arrays.copyOf(sArr, sArr.length);
        Comparator<String> stringLengthComparator = new StringLengthSort();
        Arrays.sort(splited, stringLengthComparator);
        System.out.println("\n");

        return splited[splited.length - 1];
    }
}
