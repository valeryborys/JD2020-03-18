package by.it.gutkovsky.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class TaskB2 {
    public static void main(String[] args) {
        // создание двух списков людей
        Random random = new Random();
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list1.add("name" + random.nextInt(5000));
        }
        LinkedList<String> list2 = new LinkedList<>();
            for (int i = 0; i < 25; i++) {
                list2.add("name" + random.nextInt(5000));
            }
// печать полученных спискоа - для проверки
//        System.out.println("list1 =" + list1);
//        System.out.println("list2 =" + list2);

        process(list1);
        process(list2);

    }

    static String process(ArrayList<String> peoples) {
        return null;
    }

    static String process(LinkedList<String> peoples) {
        return null;
    }

}
