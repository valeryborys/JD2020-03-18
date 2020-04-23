package by.it.verbitsky.jd02_01;

import java.util.Random;

class Helper {
    //Чем больше коэффициент - тем больше ускоряются действия покупателей,
    // при 1 - коэффициент не учитывается при определении задержек
    public static int accelerationFactor = 1;


    //коэффициент для ускорения/замедления процессов
    //в зависимости от времени и кол-ва покупателей
    //более плавное замедление
    public static int slowFactor = 0;

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
                (start + generator.nextInt(end - start + 1) * buyerSpeedFactor) + slowFactor) / accelerationFactor);
    }

    public static int getRandom(int start, int end) {
        return start + generator.nextInt(end - start + 1);
    }

    public static double getRandomPrice() {
        return generator.nextDouble() * 100;
    }


    //фактор регулирования потока покупателей в зависимости от времени и кол-ва покупателей в магазине
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

}
