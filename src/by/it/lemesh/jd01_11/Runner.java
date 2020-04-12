package by.it.lemesh.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<Short> myList = new SetC<>();
        Set<Short> arrList = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            myList.add((short) (i * 2));
            arrList.add((short) (i * 2));
            System.out.println("myList:  " + myList + "\narrList: " + arrList + "\n");
        }
    }
}
