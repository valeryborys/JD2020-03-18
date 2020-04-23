package by.it.tolstik.jd01.jd01_12;

import java.util.*;

class TaskB2 {
    static String process(ArrayList<String> peoples) {
        ArrayList<String> copyList = new ArrayList<>(peoples);
        int count = 1;
        while (copyList.size() != 1) {
            Iterator<String> iterator = copyList.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0)
                    iterator.remove();
                count++;
            }
        }
        return copyList.get(0);
}

    static String process(LinkedList<String> peoples) {
        LinkedList<String> copyList = new LinkedList<>(peoples);
        int count = 1;
        while (copyList.size() != 1) {
            Iterator<String> iterator = copyList.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0)
                    iterator.remove();
                count++;
            }
        }
        return copyList.get(0);
    }

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add("Вася" + i);
        }
        for (int i = 0; i < 5; i++) {
            linkedList.add("Коля" + i);
        }

        System.out.println(arrayList);
        System.out.println(TaskB2.process(arrayList));

        System.out.println(linkedList);
    }
}
