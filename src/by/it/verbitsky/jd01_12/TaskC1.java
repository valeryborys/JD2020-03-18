package by.it.verbitsky.jd01_12;

import java.util.*;

class TaskC1 {
    public TaskC1(Long num) {
        this.num = num;
    }

    private Long num;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskC1 instance = new TaskC1(0L);
        Map<Long, String> c = new TreeMap<>();

        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            word = word.replaceAll("([^a-zA-Z^']+)", "");
            c.put(++instance.num, word);
        }
        System.out.println(c);
        c = compressMap(c);
        System.out.println(c);
    }

    private static Map<Long, String> compressMap(Map<Long, String> c) {
        Map<String, Long> revers = new TreeMap<>();

        for (Map.Entry<Long, String> entry : c.entrySet()) {
            revers.put(entry.getValue(), entry.getKey());
        }

        c.clear();

        for (Map.Entry<String, Long> entry : revers.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        return c;
    }

}
