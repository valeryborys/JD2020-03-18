package by.it.sinevich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,4,5,5,6,6,7,7));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1,2,3,4,4,5,5,6,6,7,7));

    }
    private static Set<Integer> getUnion(Set<Integer> s, Set<Integer> i){
        Set<Integer> result = new HashSet<>(s);
        result.addAll(i);
        return result;
    }
    private static Set<Integer> getCross(Set<Integer> s, Set<Integer> i){
        Set<Integer> result = new HashSet<>(s);
        result.retainAll(i);
        return result;
    }
}
