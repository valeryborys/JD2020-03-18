package by.it.okatov.jd02_02.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {

    private static String bottomLine;

    private static final Random generator = new Random();
    private static final Map<String, Integer> hMapOfGoods = new HashMap<>();

    public static String getBottomLine() {
        return bottomLine;
    }

    public static void setBottomLine(String bottomLine) {
        Utils.bottomLine = bottomLine;
    }


    private Utils() {
    }


    public static int getRandom(int start, int end) {
        return start + generator.nextInt(end - start + 1);
    }

    public static void waitForSeconds(int timeout) {
        try {
            timeout = timeout * 10;
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
    }

    public static void waitForSeconds(float timeout) {
        try {
            timeout = timeout * 10;
            Thread.sleep((int) (timeout));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
    }

    public static Map<String, Integer> gethMapOfGoods() {
        return hMapOfGoods;
    }

    public static void sethMapOfGoods() {
        hMapOfGoods.put("Хлеб Дор-блю............", 12);
        hMapOfGoods.put("Дедушкины яйца..........", 13);
        hMapOfGoods.put("Мас-кар-поне!!..........", 15);
        hMapOfGoods.put("Утка с хреном...........", 17);
        hMapOfGoods.put("Моя баварская колбаска..", 17);
    }

    static StringBuilder setDelimiters(int spaces) {
        StringBuilder delimiter = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            delimiter.append(" ");
        }
        return delimiter;
    }


    static void printHeader(StringBuilder sb) {

        sb.append("║---------------").append("Cashier #1").append("---------------")
                .append("║---------------").append("Cashier #2").append("---------------")
                .append("║---------------").append("Cashier #3").append("---------------")
                .append("║---------------").append("Cashier #4").append("---------------")
                .append("║---------------").append("Cashier #5").append("---------------║\n");

    }

    static void printBottom(StringBuilder sb) {
        sb.append("╚════════════════════════════════════════╩")
                .append("════════════════════════════════════════╩")
                .append("════════════════════════════════════════╩")
                .append("════════════════════════════════════════╩")
                .append("════════════════════════════════════════╝\n");
    }

    static void printTop(StringBuilder sb) {
        sb.append("╔════════════════════════════════════════╦")
                .append("════════════════════════════════════════╦")
                .append("════════════════════════════════════════╦")
                .append("════════════════════════════════════════╦")
                .append("════════════════════════════════════════╗\n");
    }


}
