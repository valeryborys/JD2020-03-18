package by.it.gutkovsky.jd01_12;

import java.util.*;

class TaskB3 {
    public static void main(String[] args) {
        // создание двух списков людей
        Random random = new Random(123L);
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
//            list1.add("name" + random.nextInt(5000));
            list1.add("name" + i);
        }

        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            list2.add("name" + i);
        }
        Timer t1 = new Timer();
        process(list1);
        System.out.println("Время работы для  ArrayList=" + t1);
//        Timer t2=new Timer();
        process(list2);
        System.out.println("Время работы для LinkedList=" + t1);
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

/*   // Метод с Queue работает неверно - дорабоать!
    static String process(LinkedList<String> peoples) {
        int even = 1;
        Queue<String> peoplesCopy = new LinkedList<>();
        while (peoplesCopy.size() != 1) {
            if (even % 2.0 == 0) {
                ((Queue<String>) peoples).poll();
            } else {
                peoplesCopy.offer(peoplesCopy.poll());
            }
            even++;
        }
        return peoplesCopy.element();
    }

 */
    private static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return Delta.toString() + " мкс";
        }
    }


}



