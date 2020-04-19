package by.it.bobrovich.jd01_11;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<String> mySet = new SetC<>();
        Set<String> hashSet = new HashSet<>();
        System.out.println(mySet.size());
        System.out.println(mySet.isEmpty());
        mySet.add("One");
        mySet.add("One");
        mySet.add("Two");
        mySet.add("Three");
        mySet.add("Three");
        mySet.add("Four");
        System.out.println(mySet);
        System.out.println(mySet.size());
        System.out.println(mySet.isEmpty());
    }
}
