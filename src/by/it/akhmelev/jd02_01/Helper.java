package by.it.akhmelev.jd02_01;

import java.util.Random;

public class Helper {

    private static Random generator=new Random();

    private Helper() {
    }


    public static int getRandom(int start, int end) {
        return start+generator.nextInt(end-start+1);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Manager.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted "+Thread.currentThread(),e);
        }
    }
}
