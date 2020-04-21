package by.it.lemesh.jd01_12;

import java.util.*;

public class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9, 10, 12, 14, 5, 9));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18));
        System.out.println(getUnion(hashSet, treeSet));
        System.out.println(getCross(hashSet, treeSet));
    }
}
