package by.it.verbitsky.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TaskA2 {


    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 4, 5, 3, 2, 4, 1));
        Set<Integer> b = new HashSet<>(Arrays.asList(11, 22, 3, 4, 5, 63, 7, 4, 57, 3, 2, 14, 1));

        Set<Integer> union = getUnion(a, b);
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }
}
