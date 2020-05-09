package by.it.lemesh.jd02_01;

import java.util.Map;
import java.util.TreeMap;

public class Manager {
    static final int K_SPEED = 10;
    private static Map<Integer, Integer> map = new TreeMap<>();

    public static void report(int time) {
        map.put(time, Buyer.buyersOnline);
    }

    public static void print() {
        System.out.println(map.toString());
    }
}
