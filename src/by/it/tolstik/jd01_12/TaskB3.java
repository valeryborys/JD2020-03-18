package by.it.tolstik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class TaskB3 {
    static String process(ArrayList<String> peoples) {
        boolean flag = true;
        int count;
        while (peoples.size() > 1) {
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
        ArrayList<String> names1 = new ArrayList<>();
        LinkedList<String> names2 = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            names1.add("имя" + i);
            names2.add("имя" + i);
        }

        long t1 = System.nanoTime();
        String name = process(names1);
        System.out.println("Время работы ArrayList = " + (System.nanoTime() - t1) / 1000 + " микросек");

        long t2 = System.nanoTime();
        name = process(names2);
        System.out.println("Время работы LinkedList = " + (System.nanoTime() - t2) / 1000 + " микросек");
    }
}

