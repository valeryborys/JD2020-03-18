package by.it.szamostyanin.jd02_03;

import java.util.Random;

public class Helper {

    private static final Random generator = new Random();

    public static int getRandom(int start, int end) {
        return start + generator.nextInt(end - start);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Manager.speed);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
    }
}