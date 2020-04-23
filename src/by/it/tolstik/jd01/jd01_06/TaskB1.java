package by.it.tolstik.jd01.jd01_06;

import java.util.regex.Pattern;

class TaskB1 {
    private static void getWords() {

        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        char[] ch = {'Е', 'е', 'У', 'у', 'Ю', 'ю', 'И', 'и', 'О', 'о', 'А', 'а', 'Я', 'я', 'Ё', 'ё', 'Ы', 'ы'};
        Pattern pattern = Pattern.compile("[\\s\\.\\,\\-\\:\\!\\?]+");
        String[] arr = pattern.split(stringBuilder);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= 2) {
                int count = 0;
                int count2 = 0;
                for (int j = 0; j < ch.length; j++) {
                    if (arr[i].charAt(0) != ch[j]) {
                        count++;
                    }
                    if (arr[i].charAt(arr[i].length()-1) == ch[j]) {
                        count2++;
                    }
                    if (count == 18 & count2 == 1) {
                        System.out.println(arr[i]);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        getWords();


    }
}

