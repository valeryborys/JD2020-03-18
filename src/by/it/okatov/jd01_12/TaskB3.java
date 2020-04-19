package by.it.okatov.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> pArr = new ArrayList<>();
        LinkedList<String> pList = new LinkedList<>();
        LinkedList<String> pListQ = new LinkedList<>();
        String lastNameInArr;
        String lastNameInList;
        String lastNameInListQ;

        fillCollection(pArr);
        fillCollection(pList);
        fillCollection(pListQ);

        long lTimeNow;
        long lDelta;
        //collectionClocking(pArr, pList);

        lTimeNow = System.nanoTime();
        lastNameInArr = process(pArr);
        lDelta = (System.nanoTime() - lTimeNow) / 1000;
        System.out.println("ArrayList Performing time = " + lDelta + " microsec.");

        lTimeNow = System.nanoTime();
        lastNameInList = linkedProcess(pList);
        lDelta = (System.nanoTime() - lTimeNow) / 1000;
        System.out.println("LinkedList Performing time = " + lDelta + " microsec.");

        lTimeNow = System.nanoTime();
        lastNameInListQ = process(pListQ);
        lDelta = (System.nanoTime() - lTimeNow) / 1000;
        System.out.println("LinkedList on Queue Performing time = " + lDelta + " microsec.");

        System.out.println(lastNameInArr);
        System.out.println(lastNameInList);
        System.out.println(lastNameInListQ);

    }


    @SuppressWarnings("ALL")
    private static void collectionClocking(ArrayList<String> pArr, LinkedList<String> pList) {
        long lTimeNow;
        String lastNameInArr;
        long lDelta;
        String lastNameInList;
        for (int i = 0; i < 40; i++) {
            fillCollection(pArr);
            fillCollection(pList);
            lTimeNow = System.nanoTime();
            lastNameInArr = process(pArr);
            lDelta = (System.nanoTime() - lTimeNow) / 1000;
            //System.out.println("ArrayList Performing time = " + lDelta + " microsec.");

            lTimeNow = System.nanoTime();
            lastNameInList = linkedProcess(pList);
            lDelta = (System.nanoTime() - lTimeNow) / 1000;
            //System.out.println("LinkedList Performing time = " + lDelta + " microsec.");
            pArr.removeAll(pArr);
            pList.removeAll(pList);
        }

        fillCollection(pArr);
        fillCollection(pList);
    }

    private static void fillCollection(Collection<String> c) {
        String str = "n";
        for (int i = 1; i <= 4096; i++) {
            c.add(str + i);
        }
    }

    private static String process(LinkedList<String> peoples) {
        int i = 0;
        while (((Queue<String>) peoples).size() != 1) {
            if (i == 0 || i % 2.0 == 0) {
                ((Queue<String>) peoples).offer(((Queue<String>) peoples).poll());

            } else {
                ((Queue<String>) peoples).poll();
            }
            i++;
        }
        return ((Queue<String>) peoples).element();
    }

    public static String process(ArrayList<String> peoples) {

        ArrayList<String> res = new ArrayList<>(peoples);
        int i = 0;

        while (res.size() != 1) {
            Iterator<String> iterator = res.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2.0 == 0 || i == 0) {
                    i++;
                } else {
                    iterator.remove();
                    i++;
                }
                if (res.size() == 1) {
                    for (int j = 0; j < 4096; j++) {
                        String s = res.get(0) + i;
                    }

                }
            }
        }
        return res.get(0);

    }

    public static String linkedProcess(LinkedList<String> peoples) {
        LinkedList<String> res = new LinkedList<>(peoples);
        int i = 0;
        while (res.size() != 1) {
            ListIterator<String> iterator = res.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2.0 == 0 || i == 0) {
                    i++;
                } else {
                    iterator.remove();
                    i++;
                }
            }
        }

        return res.get(0);
    }
}
