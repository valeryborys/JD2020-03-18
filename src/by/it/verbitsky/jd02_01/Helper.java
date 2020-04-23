package by.it.verbitsky.jd02_01;

import java.util.Random;

class Helper {
    //для ускорения процессов нужно увеличить K_SPEED (ТОЛЬКО ДЛЯ ПРОВЕРКИ ЗАДАНИЯ)
    public static int kSpeed = 1;


    //коэффициент для ускорения/замедления процессов
    //в зависимости от времени и кол-ва покупателей
    public static int speedFactor = 0;

    private static Random generator = new Random();

    private Helper() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupt " + Thread.currentThread(), e);
        }
    }

    public static int getRandomTimeout(int start, int end, double buyerSpeedFactor) {
        return (int) (Math.round(
                (start + generator.nextInt(end - start + 1) * buyerSpeedFactor) + speedFactor) / kSpeed);
    }

    public static int getRandom(int start, int end) {
        return start + generator.nextInt(end - start + 1);
    }

    public static double getRandomPrice() {
        return generator.nextDouble() * 100;
    }

    public static int getCountFactor(int currentSec, int buyerCount) {
        int factor = 0;

        if (currentSec % 60 <= 30) {
            if (buyerCount < 8) {
                //людей мало - можно немного увеличить таймауты = задержать людей
                factor = 2;
                speedFactor = 1000;
                kSpeed = 1;
            }

            if (buyerCount > 8 && buyerCount < 12) {
                factor = 1;
                speedFactor = 0;
            }

            if (buyerCount > 12) {
                //людей много - гужно ускорить тех кто уже в магазине
                factor = 0;
                speedFactor = 0;
                kSpeed = 5;
            }
        } else {
            if (buyerCount < 30) {
                //людей очень мало - можно немного увеличить таймауты = задержать людей
                factor = 4;
                speedFactor = 1000;
                kSpeed = 1;
            }
            //людей по прежнему маловато
            if (buyerCount > 30 && buyerCount < 35) {
                factor = 2;
                speedFactor = 500;
                kSpeed = 1;
            }

            if (buyerCount > 35 && buyerCount < 40) {
                //людей достаточно - гужно немного ускорить тех кто уже в магазине
                factor = 1;
                speedFactor = 200;
                kSpeed = 3;
            }

            if (buyerCount > 40) {
                //людей слишком много - гужно ускорить тех кто уже в магазине
                factor = 0;
                speedFactor = 0;
                kSpeed = 5;
            }
        }
        return factor;
    }

}
