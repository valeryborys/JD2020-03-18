package by.it.borys.jd01_12;

import java.util.*;

public class TaskA2 {


    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 5, 8, 7, 6, 5, 8, 4, 5, 6, 9));
        Set<Integer> b = new HashSet<>(Arrays.asList(1, 2, 1, 4, 7, 6, 1, 8, 5, 3, 0));
        System.out.println(getUnion(a, b));
        System.out.println(getCross(a, b));
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> add = new HashSet<>();
        add.addAll(a);
        add.addAll(b);
        return add;
    }
        private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
            Set<Integer> retain = new HashSet<>(a);
            retain.retainAll(b);
            return retain;
        }


}
