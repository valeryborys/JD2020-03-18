package by.it.szamostyanin.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5));
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(-8, -6, -4, -2, 0, 2, 4, 6, 8));
        Set<Integer> union = getUnion(treeSet, hashSet);
        Set<Integer> cross = getCross(treeSet, hashSet);
        System.out.println(cross);
        System.out.println(union);
    }

    private static Set<Integer> getCross(Set<Integer> treeSet, Set<Integer> hashSet) {
        Set<Integer> result = new HashSet<>(treeSet);
        result.retainAll(hashSet);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> treeSet, Set<Integer> hashSet) {
        Set<Integer> result = new HashSet<>();
        result.addAll(treeSet);
        result.addAll(hashSet);
        return result;
    }
}