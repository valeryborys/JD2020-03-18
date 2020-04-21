package by.it.okatov.jd01_12;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TaskC2withfullgenerics {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        Set<Integer> c = new HashSet<Integer>();
        fillCollection(a, 25);
        fillCollection(b, 19);
        fillCollection(c, 33);

        System.out.println("Set A:");
        System.out.println(a);
        System.out.println("Set B:");
        System.out.println(b);
        System.out.println("Set C:");
        System.out.println(c);

        Collection<?> union = getUnion(a, b, c);
        Collection<?> cross = getCross(a, b, c);


        System.out.println("Union:");
        System.out.println(union);
        System.out.println("Cross:");
        System.out.println(cross);
    }

    private static <T extends Collection, E extends Number> Collection<E> getCross(Collection<E>... collections) {
        Collection<E> tmp = collections[0];
        for (Collection<E> col : collections) {
            tmp.retainAll(col);
        }
        return tmp;
    }


    private static <T extends Collection, E extends Number> Collection<E> getUnion(Collection<E>... collections) {
        Collection<E> tmp = collections[0];
        for (Collection<E> col : collections) {
            tmp.addAll(col);
        }
        return tmp;
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
