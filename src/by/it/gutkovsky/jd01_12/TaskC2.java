package by.it.gutkovsky.jd01_12;

import java.util.*;

class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.
                asList(-1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 1)
        );
        Set<Double> b = new HashSet<>(Arrays.
                asList(4.0, 5.0, 9.0, 8.0, 24.0, 34.0, 2.0, 1.0)
        );
        Set<?> union = getUnion(a, b);
        System.out.printf("a=%s\nb=%s\nu=%s\n", a, b, union);
        Set<?> cross = getCross(a, b);
        System.out.printf("a=%s\nb=%s\ncross=%s\n", a, b, cross);
    }

    private static <T extends Number> Set<T> getCross(Set<?>... a) {

        Set<T> crossResult = new HashSet<>();
        Set<T> temp = new HashSet<>();

        for (Object o : a[0]) {
            o = Double.valueOf(o.toString());
            crossResult.add((T) o);
        }
        for (int i = 0; i < a.length; i++) {
            for (Object o : a[i]) {
                o = Double.valueOf(o.toString());
                temp.add((T) o);
            }
            crossResult.retainAll(temp);
            temp.clear();
        }
        return crossResult;
    }

    private static <T extends Number> Set<T> getUnion(Set<? extends Number>... a) {
        Set<T> result = new HashSet<>();
        for (Set<?> element : a) {
            for (Object o : element) {
                o = Double.valueOf(o.toString());
                result.add((T) o);
            }
        }
        return result;
    }
}

