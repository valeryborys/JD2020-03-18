package by.it.bobrovich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            arrayList.add(String.valueOf(i));
            linkedList.add(String.valueOf(i));
        }
        long start1 = System.nanoTime();
        System.out.println(process(arrayList));
        System.out.println(System.nanoTime() - start1);
        long start2 = System.nanoTime();
        System.out.println(process(linkedList));
        System.out.println(System.nanoTime() - start2);

    }

    private static String process(ArrayList<String> namesArray) {
        int i = 0;
        while(namesArray.size()>1) {
            Iterator<String> iterator = namesArray.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if(i++ % 2 !=0){
                    iterator.remove();
                }
            }
        }
        return namesArray.get(0);
    }
    private static String process(LinkedList<String> namesArray) {
        int i = 0;
        while(namesArray.size()>1) {
            Iterator<String> iterator = namesArray.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if(i++ % 2 !=0){
                    iterator.remove();
                }
            }
        }
        return namesArray.get(0);
    }
}
