package by.it.okatov.jd01_12;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));
        /*fillCollection(a, 25);
        fillCollection(b, 19);
        fillCollection(c, 33);*/

        System.out.println("Set A:");
        System.out.println(a);
        System.out.println("Set B:");
        System.out.println(b);
        System.out.println("Set C:");
        System.out.println(c);
        System.out.println("Set D:");
        System.out.println(d);

        System.out.println();
        Collection<?> union = getUnion(a, b, c, d);
        Collection<?> cross = getCross(a, b, c, d);


        System.out.println("Union: " + union.size());
        System.out.println(union);
        System.out.println("Cross:" + cross.size());
        System.out.println(cross);
    }

    private static <T extends Number> Set<T> getUnion(Set<? extends Number>... sets) {


        Set<T> result = new HashSet<>();
        Set<T> setsTmp = new HashSet<>();
        for (Set<?> set : sets) {
            for (Object o : set) {
                o = Double.valueOf(o.toString());
                setsTmp.add((T) o);
            }
            result.addAll(setsTmp);
        }
        return result;
    }


    private static <T extends Number> Set<T> getCross(Set<?>... sets) {
        Set<T> result = new HashSet<>();
        Set<T> setsTmp = new HashSet<>();
        for (Object o : sets[0]) {
            o = Double.valueOf(o.toString());
            result.add((T) o);
        }
        for (int i = 1; i < sets.length; i++) {
            for (Object o : sets[i]) {
                o = Double.valueOf(o.toString());
                setsTmp.add((T) o);
            }
            result.retainAll(setsTmp);
            setsTmp.removeAll(setsTmp);
        }
       /* for (Set<?> set : sets) {
            for (Object o : set) {
                o = Double.valueOf(o.toString());
                setsTmp.add((T) o);
            }
            result.retainAll(setsTmp);
        }*/
        return result;
    }



   /* private static Set<Integer> getCross(Set<Integer> col1, Set<Integer> col2) {
        Set<Integer> res = new HashSet<>(col1);
        res.retainAll(col2);
        return res;
    }
    private static Set<Integer> getUnion(Set<Integer> col1, Set<Integer> col2) {
        Set<Integer> res = new HashSet<>();
        res.addAll(col1);
        res.addAll(col2);

        return res;
    }*/

    private static void fillCollection(Set<Integer> setCollection, int size) {
        for (int i = 0; i < size; i++) {
            setCollection.add((int) (Math.random() * size * 2 - size + 1));
        }
    }
}
