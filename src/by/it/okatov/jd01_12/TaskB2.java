package by.it.okatov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> pArr = new ArrayList<>();
        LinkedList<String> pList = new LinkedList<>();
        String lastNameInArr;
        String lastNameInList;

        pArr.add("Sasha");
        pArr.add("Vova");
        pArr.add("Petya");
        pArr.add("Misha");
        pArr.add("Masha");
        pArr.add("Slava");
        pArr.add("Sveta");
        pArr.add("Ira");

        pList.add("Sasha");
        pList.add("Vova");
        pList.add("Petya");
        pList.add("Misha");
        pList.add("Masha");
        pList.add("Slava");
        pList.add("Sveta");
        pList.add("Ira");

        lastNameInArr = process(pArr);
        lastNameInList = process(pList);

        System.out.println(lastNameInArr);
        System.out.println(lastNameInList);
    }

    static String process(ArrayList<String> peoples) {
        int i = 0;

        String last = peoples.get(0);
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                last = iterator.next();

                if (i % 2.0 == 0 || i == 0) {
                    i++;
                } else {
                    iterator.remove();
                    i++;
                }


                if (peoples.size() == 1) {
                    last = peoples.toString();
                }
            }
        }
        return last;

    }

    static String process(LinkedList<String> peoples) {
        int i = 0;
        String last = peoples.getFirst();
        while (peoples.size() != 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                last = iterator.next();
                if (i % 2.0 == 0 || i == 0) {
                    i++;
                } else {
                    iterator.remove();
                    i++;
                }
            }

            if (peoples.size() == 1) {
                last = peoples.toString();
            }
        }

        return last;
    }
}
