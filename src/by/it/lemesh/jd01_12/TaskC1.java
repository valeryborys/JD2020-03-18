package by.it.lemesh.jd01_12;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskC1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Scanner sc = new Scanner(System.in);
        String line;
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashMap<Integer, String> newHashMap = new HashMap<>();
        while (!(line = sc.nextLine()).equals("end")) {
            hashMap.put(atomicInteger.incrementAndGet(), line);
        }
        System.out.println(hashMap.toString());
        newHashMap = removeIfRepeat(hashMap);
        System.out.println(newHashMap.toString());
    }

    static HashMap<Integer, String> removeIfRepeat(HashMap<Integer, String> map) {
        HashMap<Integer, String> copy = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (!copy.containsValue(entry.getValue())) {
                copy.put(entry.getKey(), entry.getValue());
            }
        }
        return copy;
    }
}


