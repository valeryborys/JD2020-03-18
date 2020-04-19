package by.it.borys.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 5, 8, 7, 6, 5, 8, 4, 5, 6, 9));
        Set<Float> b = new TreeSet<>(Arrays.asList(1f, 2f, 1f, 4f, 7f, 6f, 1f, 8f, 5f, 3f, 0f));
        Set<Byte> c = new HashSet<Byte>(Arrays.asList((byte)1,(byte)2, (byte)4,(byte)118));//разобраться как привести числа к byte
        Set<Double> d = new HashSet<Double>(Arrays.asList(12.4d,2d,4d,8d,6d,9d));
        Set<Long> e = new HashSet<Long>(Arrays.asList(4L, 1L, 2L, 3L, 1548L, 2L));
        System.out.println(getUnion(a,b,c,d,e));
        System.out.println(getCross(a,b,c,d,e));
    }

    private static Set<Double> getUnion(Set<? extends Number>... set) {
        Set<Double> union = new HashSet<>();
        for (Set<? extends Number> set1:set) {
                for (Number number : set1) {
                    union.add(number.doubleValue());
            }
        }
        return union;
    }
    private static Set<Double> getCross(Set<? extends Number>... set){
        Set<Double> retain = new HashSet<>();
        for (Number number : set[0]) {
            retain.add(number.doubleValue());
        }
        for (int i =1; i<set.length;i++) {
            Set<Double> temp = new HashSet<>();
            for (Number number : set[i]) {
                temp.add(number.doubleValue());
            }
            retain.retainAll(temp);
        }
        return retain;
    }


}
