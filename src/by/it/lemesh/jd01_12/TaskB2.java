package by.it.lemesh.jd01_12;

import java.util.*;

public class TaskB2 {

    static String process(ArrayList<String> peoples) {
        boolean flag = true;
        int count;
        while (peoples.size() > 1) {
            System.out.println(peoples);
            if (flag) count = 0;
            else count = 1;
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 2 == 0) {
                    it.remove();
                    flag = true;
                } else flag = false;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean flag = true;
        int count;
        while (peoples.size() > 1) {
            System.out.println(peoples);
            if (flag) count = 0;
            else count = 1;
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 2 == 0) {
                    flag = true;
                    it.remove();
                } else flag = false;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        LinkedList<String> names2 = new LinkedList<>();
        names.add("Вася");
        names.add("Петя");
        names.add("Коля");
        names.add("Слава");
        names.add("Женя");
        names2.add("Вася");
        names2.add("Петя");
        names2.add("Коля");
        names2.add("Слава");
        names2.add("Женя");
        String name = process(names2);
        System.out.println(name);
    }
}
