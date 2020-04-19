package by.it.bobrovich.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        List<String> values = getValues();
        List<Integer> keys = getKeys(values.size());
        for (int i = 0; i < values.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        System.out.println(map);
        deleteList(map);
        System.out.println(map);
    }

    private static void deleteList(Map<Integer, String> map) {
        Map<String, Integer> map1 = new TreeMap<>();
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            map1.put(entry.getValue(), entry.getKey());
        }
        map.clear();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
    }

    private static List<String> getValues() {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        while(!(str = sc.next()).equals("end")){
            list.add(str);
        }
        return list;
    }

    private static List<Integer> getKeys(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int key = (int) (Math.random()*1000000);
            if(!list.contains(key))
                list.add(key);
        }
        return list;
    }
}
