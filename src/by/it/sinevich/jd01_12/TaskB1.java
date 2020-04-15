package by.it.sinevich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int rate = 0;
        while (!(str = sc.next()).equals("end")) {
            list.add(sc.next());
        }
        for (int i = 0; i < list.size(); i++) {
            rate = 1;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    rate++;
                }
            }
            set.add(list.get(i) +"="+ rate);
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
