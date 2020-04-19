package by.it.bobrovich.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));

        Set<Number> union = getUnion(a, b, c, d);
        System.out.println(union);
        Set<Number> cross = getCross(a, b, c, d);
        System.out.println(cross);
    }

    private static <T extends Number>Set<T> getCross(Set<? extends Number>... args ) {
        Set<T> result = new HashSet<>();
        for (Set<? extends Number> arg : args) {
            for (Number number : arg) {
                result.add((T) Double.valueOf(number.toString()));
            }
            break;
        }
        Set<T> buffer = new HashSet<>();
        for (Set<? extends Number> arg : args) {
            for (Number number : arg) {
                buffer.add((T) Double.valueOf(number.toString()));
            }
            result.retainAll(buffer);
            buffer.clear();
        }
        return result;
    }

    private static <T extends Number>Set<T> getUnion(Set<? extends Number>... args ) {
        Set<T> result = new HashSet<>();
       // Set<Object> tmp = new HashSet<>();
        for (Set<? extends Number> arg : args) {
            for (Number number : arg) {
                result.add((T) Double.valueOf(number.toString()));
            }
        }
        return result;
    }

}
