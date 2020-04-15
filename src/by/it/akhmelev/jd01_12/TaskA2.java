package by.it.akhmelev.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays
                .asList(-1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 1)
        );
        Set<Integer> b = new HashSet<>(Arrays
                .asList(4, 5, 6, 7, 8, 9, 34, 8)
        );
        Set<Integer> union=getUnion(a,b);
        System.out.printf("a=%s\nb=%s\nu=%s\n",a,b,union);

    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result=new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
