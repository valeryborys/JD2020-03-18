package by.it.borys.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        int peopleNumber = 41;
        ArrayList<String> peoples = new ArrayList<>();
        for (int i = 1; i <= peopleNumber; i++) {
            peoples.add("human"+i);
        }
        long startA = System.nanoTime();
        System.out.println(process(peoples));
        long timeA = System.nanoTime()-startA;
        System.out.println(timeA/1000);

        LinkedList<String> peoples1 = new LinkedList<>();
        for (int i = 1; i <= peopleNumber; i++) {
            peoples1.add("human"+i);
        }
        long startB = System.nanoTime();
        System.out.println(process(peoples1));
        long timeB = System.nanoTime()-startB;
        System.out.println(timeB/1000);
    }
    static String process(ArrayList<String> peoples) {
        int count = 0;
        while (peoples.size() != 1){
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (count % 2 != 0) it.remove();
                count++;
            }
        }
       return peoples.get(0);
    }
    static String process(LinkedList<String> peoples1) {
            int count = 0;
            while (peoples1.size() !=1) {
                if (count % 2 != 0 ) {
                    peoples1.remove();
                } else{
                peoples1.addLast(peoples1.pollFirst());}
                count++;
                }
       return peoples1.get(0);
    }

}
