package by.it.bobrovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 3, 3, 4, 5, 6));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(9, 8, 7, 3, 3, 4, 5, 6));
        System.out.println(getCross(treeSet, hashSet));
        System.out.println(getUnion(treeSet, hashSet));
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> set = new HashSet<>(one);
        set.retainAll(two);
        return set;
    }
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> set = new HashSet<>(one);
        set.addAll(two);
        return set;
    }
}
