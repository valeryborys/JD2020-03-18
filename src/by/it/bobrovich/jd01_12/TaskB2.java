package by.it.bobrovich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> namesArray =
                new ArrayList<>(Arrays.asList("Petya", "Kolya", "Vasya", "Ivan", "Igor", "Kirill", "Vasya"));
        LinkedList<String> namesLinked =
                new LinkedList<>(Arrays.asList("Petya", "Kolya", "Vasya", "Ivan", "Igor", "Kirill", "Vasya"));

        System.out.println(process(namesArray));
        System.out.println(process(namesLinked));
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
