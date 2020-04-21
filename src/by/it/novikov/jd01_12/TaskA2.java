package by.it.novikov.jd01_12;

import java.util.*;

class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 4));
        Set<Integer> b = new TreeSet<>(Arrays.asList(3, 1, 1, 5, 9, 2, 6, 20, 21, 22));
        System.out.println(getCross(a, b));
        System.out.println(getCrossWithRetainAll(a, b));
        System.out.println(getUnion(a, b));
        System.out.println(getUnionWithAddAll(a, b));
    }

    private static Set<Integer> getCrossWithRetainAll(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            int set1Member = iterator.next();
            if (set2.contains(set1Member)) {
                result.add(set1Member);
            }
        }
        return result;

    }

    private static Set<Integer> getUnionWithAddAll(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            int set2Member = iterator.next();
            result.add(set2Member);

        }
        return result;
    }
}