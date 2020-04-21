package by.it.novikov.jd01_12;

import java.util.*;

class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peolpesArray = new ArrayList<>();
        LinkedList<String> peolpesLinked = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            peolpesArray.add("Vova");
            peolpesLinked.add("Gily");
        }
        System.out.println(process(peolpesArray));
        System.out.println(process(peolpesLinked));
        System.out.println(processWithQueue(peolpesLinked));

    }

    static String process(ArrayList<String> peoples) {
        long start = System.currentTimeMillis();
        int counter = 1;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter--;
                } else {
                    counter++;
                }
            }
        }
        System.out.println("Время для process (ArrayList) : " + (System.currentTimeMillis() - start));
        return peoples.get(0);
    }

    static String processWithQueue(LinkedList<String> peoples) {
        long start = System.currentTimeMillis();
        LinkedList<String> queue = new LinkedList<>(peoples);
        int counter = 1;
        while (queue.size() > 1) {
            if (counter == 1) {
                queue.addLast(queue.pollFirst());
                counter++;
            } else {
                queue.pollFirst();
                counter--;
            }
        }
        System.out.println("Время для process Queue (LinkedList) : " + (System.currentTimeMillis() - start));
        return queue.pollFirst();
    }

    static String process(LinkedList<String> peoples) {
        long start = System.currentTimeMillis();
        int counter = 1;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter--;
                } else {
                    counter++;
                }
            }
        }
        System.out.println("Время для process (LinkedList) : " + (System.currentTimeMillis() - start));
        return peoples.get(0);
    }

}