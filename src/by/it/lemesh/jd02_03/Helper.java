package by.it.lemesh.jd02_03;

import java.util.*;

public class Helper {
    private static Random gen = new Random();
    static Map<String, Integer> map = new HashMap<>();
    static List<String> keysList = new ArrayList<>();

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
        if (time == 0) result = 20;
        else if (time < 30) {
            int buyersOnline = Manager.getOnlineBuyers();
            if (buyersOnline - time < 10) result = (time + 10 - buyersOnline) * 2;
        } else if (time < 60) {
            int buyersOnline = Manager.getOnlineBuyers();
            if (buyersOnline <= 70 - time) result = (70 - time - buyersOnline) * 2;
        } else if (time < 90) {
            int buyersOnline = Manager.getOnlineBuyers();
            if (buyersOnline - time + 60 < 10) result = (time - 60 + 10 - buyersOnline) * 2;
        } else {
            int buyersOnline = Manager.getOnlineBuyers();
            if (buyersOnline <= 130 - time) result = (130 - time - buyersOnline) * 2;
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
