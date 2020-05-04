package by.it.verbitsky.jd02_03;

import java.util.Random;

class Helper {
    //для тестирования - уменьшает все задержки в N раз
    private static final int K_SPEED = 100;

    //Чем больше коэффициент - тем больше ускоряются действия покупателей,
    // при 1 - коэффициент не влияет на задержки
    public static int accelerationFactor = 1;

    //коэффициент для ускорения/замедления процессов
    //в зависимости от времени и кол-ва покупателей
    //более плавное замедление
    public static int slowFactor = 0;

    public static int getServiceSpeedFactor() {
        return K_SPEED;
    }

    private static Random generator = new Random();

    public static void serviceSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupt " + Thread.currentThread(), e);
        }
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupt " + Thread.currentThread(), e);
        }
    }

    public static int getRandomTimeout(int start, int end, double buyerSpeedFactor) {
        return (int) (Math.round(
                (start + generator.nextInt(end - start + 1) * buyerSpeedFactor) + slowFactor)
                / accelerationFactor
                / K_SPEED);
    }

    public static int getRandom(int start, int end) {
        return start + generator.nextInt(end - start + 1);
    }

    public static double getRandomPrice() {
        return generator.nextDouble() * 100;
    }

    //Немного захардкодил этот метод - определяет предел кол-ва генерируемых покупателей за цикл

    public static int getCountFactor(int currentSec, int buyerCount) {
        int factor = 0;

        if (currentSec <= 30) {
            factor = 10 + currentSec - buyerCount;
            if (factor < 0) {
                factor = 0;
            }
        }

        if (currentSec > 30 && currentSec <= 40) {
            if (buyerCount <= 30) {
                factor = 10;
            }
            if (buyerCount > 30 && buyerCount < 35) {
                factor = 7;
            }
        }

        if (currentSec > 40 && currentSec <= 50) {
            if (buyerCount > 30 && buyerCount <= 35) {
                factor = 7;
            }
            if (buyerCount > 20 && buyerCount <= 30) {
                factor = 6;
            }
        }
        if (currentSec > 50 && currentSec <= 59) {
            if (buyerCount > 25) {
                factor = 5;
            }
            if (buyerCount > 12 && buyerCount < 25) {
                factor = 3;
            }
            if (buyerCount > 8 && buyerCount < 12) {
                factor = 2;
            }

        }


        return factor;
    }

    private Helper() {
    }

}
