package by.it.lemesh.jd02_01;

import java.util.*;

public class Helper {
    private static Random gen = new Random();
    private static Map<String, Integer> map = new HashMap<>();
    private static List<String> keysList = new ArrayList<>();
    private static int base1 = 8;
    private static int base2 = 12;
    private static int base3 = 8;
    private static int base4 = 12;


    private Helper() {
    }

    public static int getRandom(int start, int end) {
        return start + gen.nextInt(end - start + 1);
    }

    public static void sleep(int timeOut) {
        try {
            Thread.sleep((int) (timeOut / Manager.K_SPEED));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
    }

    public static String takeAGood() {
        int i = getRandom(0, 9);
        Integer value = map.get(keysList.get(i));
        return "took " + keysList.get(i) + " for " + value + " dollars";
    }

    public static void fillMarketWithGoods() {
        map.put("milk", 3);
        map.put("bread", 2);
        map.put("candy", 5);
        map.put("ice cream", 7);
        map.put("apples", 10);
        map.put("broccoli", 9);
        map.put("chips", 4);
        map.put("sausages", 11);
        map.put("coffee", 8);
        map.put("tea", 6);
        Set<String> keys = map.keySet();
        keysList.addAll(keys);
        Collections.shuffle(keysList);
    }

    public static int getCount(int time) {
        int result = 0;
        if (time < 2)
            result = 5;
        else if (time < 30) {
            if (Buyer.buyersOnline - time < 10) {
                result = base1 - Buyer.buyersOnline + time;
                base1++;
            } else
                result = 10;
        } else if (time < 60) {
            if (time < 35) {
                result = base2--;
            } else if (Buyer.buyersOnline < (70 - time)) {
                result = 7;
            } else
                result = 1;
        } else if (time < 90) {
            if (Buyer.buyersOnline - time + 60 < 14) {
                result = base3 - Buyer.buyersOnline + time - 60;
                if (time < 75) base3++;
            } else
                result = 10;
        } else {
            if (time < 95) {
                result = base4--;
            } else if (Buyer.buyersOnline < (130 - time)) {
                result = 7;
            } else
                result = 1;
        }
        return result;
    }
}
