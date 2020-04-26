package by.it.verbitsky.jd02_02;

import java.util.Random;

class Helper {
    //для тестирования - уменьшает все задержки в N раз
    private static final int K_SPEED = 1;

    //Чем больше коэффициент - тем больше ускоряются действия покупателей,
    // при 1 - коэффициент не влияет на задержки
    public static int accelerationFactor = 1;

    //коэффициент для ускорения/замедления процессов
    //в зависимости от времени и кол-ва покупателей
    //более плавное замедление
    public static int slowFactor = 0;

    private static Random generator = new Random();

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
        currentSec = currentSec % 60;
        //if (currentSec % )

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
/*
    //фактор регулирования потока покупателей в зависимости от времени и кол-ва покупателей в магазине
    //не совсем понял правильно задание, поэтому не совсем правильно корректировал коэффициент
    public static int getCountFactor(int currentSec, int buyerCount) {
        int factor = 0;

        if (currentSec % 60 <= 30) {
            if (buyerCount < 8) {
                //людей мало - можно немного увеличить таймауты = задержать людей
                factor = 3;
                slowFactor = 2000;
                accelerationFactor = 1;
            }
            //среднее кол-во людей
            if (buyerCount > 8 && buyerCount < 12) {
                factor = 1;
                slowFactor = 1000;
            }

            if (buyerCount > 12) {
                //людей много - гужно ускорить тех кто уже в магазине
                factor = 0;
                slowFactor = 0;
                accelerationFactor = 4;
            }
        } else {
            if (buyerCount < 30) {
                //людей очень мало - можно немного увеличить таймауты = задержать людей
                factor = 6;
                slowFactor = 1500;
                accelerationFactor = 1;
            }
            //людей по прежнему маловато
            if (buyerCount > 30 && buyerCount < 35) {
                factor = 4;
                slowFactor = 1000;
                accelerationFactor = 1;
            }

            if (buyerCount > 35 && buyerCount < 40) {
                //людей достаточно - нужно немного ускорить тех кто уже в магазине
                factor = 3;
                slowFactor = 500;
                accelerationFactor = 2;
            }

            if (buyerCount > 40) {
                //людей слишком много - гужно ускорить тех кто уже в магазине
                factor = 0;
                slowFactor = 0;
                accelerationFactor = 5;
            }
        }
        return factor;
    }
*/
}
