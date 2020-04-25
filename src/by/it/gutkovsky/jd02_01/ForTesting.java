package by.it.gutkovsky.jd02_01;

import java.util.*;

class ForTesting {

    static void printingMap(Map<Integer, Integer>  mapForChecking) {


        List<Integer> timeList = new ArrayList<>();
        List<Integer> quantity = new ArrayList<>();

        Iterator<Map.Entry<Integer, Integer>> iterator = mapForChecking.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            int key = pair.getKey();
            int value = pair.getValue();
            timeList.add(key);
            quantity.add(value);
        }
        System.out.println();
        System.out.println(mapForChecking.toString());
        System.out.println();
//        System.out.println(timeList);
        for (Integer integer : quantity) {
            System.out.println(integer);
        }
    }

    }


