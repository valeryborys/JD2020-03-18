package by.it.gutkovsky.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    public static void main(String[] args) {
//        Integer[] valueA = {-1,2,3,4,5,6,7,4,3,2,1};
//        List<Integer> integersA = Arrays.asList(-1,2,3,4,5,6,7,4,3,2,1); //
        Set<Integer> a = new TreeSet<>(Arrays.
                asList(-1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 1)
        );
        Set<Integer> b = new HashSet<>(Arrays.
                asList( 4, 5, 9, 8, 24, 34, 2, 1)
        );
        Set<Integer> union = getUnion(a, b);
        System.out.printf("a=%s\nb=%s\nu=%s\n", a,b,union);
        Set<Integer> cross = getCross(a, b);
        System.out.printf("a=%s\nb=%s\ncross=%s\n", a,b,cross);

    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> crossResult = new HashSet<>(a);
        crossResult.retainAll(b);
        return crossResult;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

}
