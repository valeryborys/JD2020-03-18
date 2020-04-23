package by.it.tolstik.jd01.jd01_12;

import java.util.*;

class TaskB1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> nextList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        while (!(text = scanner.next()).equals("end")) {
            list.add(text);
        }
        for (int i = 0; i < list.size(); i++) {
            nextList.add(list.get(i).replaceAll("[^-a-z'A-Z]+", ""));
        }
        System.out.println(list);
        System.out.println(nextList);

        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator<String> iterator = nextList.iterator();
        while (iterator.hasNext()) {
            String elem = iterator.next();
            if (hashMap.containsKey(elem)) {
                for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
                    if (pair.getKey().equals(elem)) {
                        pair.setValue(pair.getValue() + 1);
                    }
                }
            } else {
                hashMap.put(elem, 1);
            }
        }
        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            String key = pair.getKey();
            int value = pair.getValue();
            System.out.printf("%s=%d\n", key, value);
        }
    }
}
