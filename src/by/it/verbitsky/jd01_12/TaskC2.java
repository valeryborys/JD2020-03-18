package by.it.verbitsky.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TaskC2 {
    public static void main(String[] args) {
        Set<? extends Number> floats = new HashSet<>(Arrays.asList(1F, 2F, 3F));
        Set<? extends Number> doubles = new HashSet<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Set<? extends Number> longs = new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Set<? extends Number> integers = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Float set");
        System.out.println(floats);
        System.out.println("Double set");
        System.out.println(doubles);
        System.out.println("Integer set");
        System.out.println(integers);
        System.out.println("Long set");
        System.out.println(longs);

        System.out.println("\n Union set");
        Set<? extends Number> union = getUnion(floats, longs, integers, doubles);
        System.out.println(union);

        System.out.println("\n Cross set");
        Set<? extends Number> cross = getCross(floats, longs, integers, doubles);
        System.out.println(cross);

    }

    private static <T extends Number> Set<T> getUnion(Set<? extends Number>... args) {
        Set<T> res = new HashSet<>();
        Set<T> setsTmp = new HashSet<>();
        for (Set<?> set : args) {
            for (Object o : set) {
                o = Double.valueOf(o.toString());
                setsTmp.add((T) o);
            }
            res.addAll(setsTmp);
        }
        return res;
    }


    private static <T extends Number> Set<T> getCross(Set<? extends Number>... args) {
        Set<T> res = new HashSet<>();
        Set<T> bufSet = new HashSet<>();
        for (Object o : args[0]) {
            o = Double.valueOf(o.toString());
            //добавляем 1-ю коллекцию в результирующую, и потом будем кроссить с ней остальные
            res.add((T) o);
        }
        for (int i = 1; i < args.length; i++) {
            for (Object o : args[i]) {
                o = Double.valueOf(o.toString());
                bufSet.add((T) o);
            }
            //кроссим с результатом
            res.retainAll(bufSet);
            //чистим буфер
            bufSet.clear();
        }
        return res;
    }
}
