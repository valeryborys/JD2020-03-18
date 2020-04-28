package by.it.lemesh.jd02_02;

import java.util.*;

public class Helper {
    private static Random gen = new Random();
    static Map<String, Integer> map = new HashMap<>();
    static List<String> keysList = new ArrayList<>();
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

    public static void printReport() {
        System.out.printf("%20s%20s%20s%20s%20s%20s%20s\n", "Cashier #1", "Cashier #2", "Cashier #3", "Cashier #4", "Cashier #5", "Queue size", "Total amount");
    }

    public static String getTab1(int number) {
        String result;
        switch (number) {
            case 2:
                result = "\t\t\t\t\t";
                break;
            case 3:
                result = "\t\t\t\t\t\t\t\t\t\t";
                break;
            case 4:
                result = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 5:
                result = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            default:
                result = "";
        }
        return result;
    }

    public static String getTab2(int number) {
        String result;
        switch (number) {
            case 1:
                result = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 2:
                result = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 3:
                result = "\t\t\t\t\t\t\t\t\t\t";
                break;
            case 4:
                result = "\t\t\t\t\t";
                break;
            default:
                result = "";
        }
        return result;
    }
}
