package by.it.tolstik.jd02_01;

import java.util.Random;

class Helper {

    private static final Random random = new Random();

    private Helper() {

    }

    public static int getRandom(int start, int end) {
        return start + random.nextInt(end - start + 1);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
        }
    }

    public static void sleep(int timeout, int speed) {
        try {
            Thread.sleep(timeout / speed);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
        }
    }

}
