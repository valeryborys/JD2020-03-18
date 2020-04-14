package by.it.gutkovsky.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

class TaskB3 {
    public static void main(String[] args) {
        // создание двух списков людей
        Random random = new Random(123L);
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list1.add("name" + random.nextInt(5000));
        }
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list2.add("name" + random.nextInt(5000));
        }

        System.out.println(process(list1));
        System.out.println(process(list2));
    }

    static String process(ArrayList<String> peoples) {
        ArrayList<String> peoplesCopy = new ArrayList<>(peoples);
        int even = 1;
        while (peoplesCopy.size() != 1) {
            Iterator<String> iterator = peoplesCopy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (even % 2 == 0) iterator.remove();
                even++;
            }
        }
        return peoplesCopy.get(0);
    }

    static String process(LinkedList<String> peoples) {
        LinkedList<String> peoplesCopy = new LinkedList<>(peoples);
        int even = 1;
        while (peoplesCopy.size() != 1) {
            Iterator<String> iterator = peoplesCopy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (even % 2 == 0) iterator.remove();
                even++;
            }
        }
        return peoplesCopy.get(0);
    }
}
