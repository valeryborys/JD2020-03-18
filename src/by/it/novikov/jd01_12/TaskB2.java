package by.it.novikov.jd01_12;

import java.util.*;

class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peolpesArray = new ArrayList<>();
        peolpesArray.add("Asa");
        peolpesArray.add("Loka");
        peolpesArray.add("Hilart");
        peolpesArray.add("Bonne");
        peolpesArray.add("koko");
        peolpesArray.add("Gily");
        peolpesArray.add("Vins");
        peolpesArray.add("Andrey");
        peolpesArray.add("Toha");
        LinkedList<String> peolpesLinked = new LinkedList<>();
        peolpesLinked.add("Asa");
        peolpesLinked.add("Loka");
        peolpesLinked.add("Hilart");
        peolpesLinked.add("Bonne");
        peolpesLinked.add("koko");
        peolpesLinked.add("Gily");
        peolpesLinked.add("Vins");
        peolpesLinked.add("Andrey");
        peolpesLinked.add("Toha");

        System.out.println(process(peolpesArray));
        System.out.println(process(peolpesLinked));
    }

    static String process(ArrayList<String> peoples) {
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
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
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
        return peoples.get(0);
    }

}