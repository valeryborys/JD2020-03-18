package by.it.okatov.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {

    static Random generator = new Random();

    private static final Map<String, Integer> hMap = new HashMap<>();

    public static Map<String, Integer> gethMap() {
        return hMap;
    }

    public static void sethMap() {
        Utils.hMap.put("Хлеб Дор-блю", 2);
        Utils.hMap.put("Дедушкины яйца", 4);
        Utils.hMap.put("Мас-кар-поне!!", 5);
        Utils.hMap.put("Утка с хреном", 12);
    }

    public static int globalCounter = 0;

    public static int getRandom(int startRange, int endRange) {
        return startRange + generator.nextInt(endRange - startRange + 1);
    }

    public static int getRandom(float startRange, float endRange) {
        return (int) startRange + generator.nextInt((int) (endRange - startRange + 1));
    }

    public static void waitForSeconds(int seconds) {
        long millisec = seconds * 1000;
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException("Wait() was interrupted by thread " + Thread.currentThread()
                                               + "trace:\n", e);
        }
    }

    public static void waitForSeconds(float seconds) {
        long millisec = (long) (seconds * 1000);
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException("Wait() was interrupted by thread " + Thread.currentThread()
                                               + "trace:\n", e);
        }
    }


}
