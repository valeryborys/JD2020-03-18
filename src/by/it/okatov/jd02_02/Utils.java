package by.it.okatov.jd02_02;

import java.util.*;

class Utils {

    static Random generator = new Random();

    /***
     * Хэш-карта для хранения списка продуктов
     */
    private static final Map<String, Integer> hMap = new HashMap<>();
    /***
     * Глобальный счетчик количества людей на данный момент
     * находящихся в магазине
     */
    public static int GLOBAL_COUNTER = 0;

    public static Map<String, Integer> gethMap() {
        return hMap;
    }

    public static void sethMap() {
        Utils.hMap.put("Хлеб Дор-блю", 2);
        Utils.hMap.put("Дедушкины яйца", 4);
        Utils.hMap.put("Мас-кар-поне!!", 5);
        Utils.hMap.put("Утка с хреном", 12);
    }

    /***
     * Список покупателей в магазине
     */
    static List<Thread> lBuyers = new ArrayList<>();
    static List<Thread> lCashiers = new ArrayList<>();


    /***
     * Возвращает случайное число в заданном диапазоне по формуле
     * начало + случайное_от(конец - начало + 1)
     * @param startRange типа Integer. Стартовое значение диапазона
     * @param endRange типа Integer. Заключительное значение диапазона
     * @return возвращает рандомное число типа Integer
     */
    public static int getRandom(int startRange, int endRange) {
        return startRange + generator.nextInt(endRange - startRange + 1);
    }

    /***
     * Для чисел с плавающей точкой.
     * Возвращает случайное число в заданном диапазоне по формуле
     * начало + случайное_от(конец - начало + 1)
     * @param startRange типа Float. Стартовое значение диапазона
     * @param endRange типа Float. Заключительное значение диапазона
     * @return возвращает рандомное число типа Integer
     */
    public static int getRandom(float startRange, float endRange) {
        return (int) startRange + generator.nextInt((int) (endRange - startRange + 1));
    }

    /***
     * Таймер ожидания в секундах. Вызывает внутри Thread.sleep()
     * @param seconds целое количество секунд ожидания
     */
    public static void waitForSeconds(int seconds) {
        long millisec = seconds * 10;
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException("Wait() was interrupted by thread " + Thread.currentThread()
                                               + "trace:\n", e);
        }
    }

    /***
     * Для чисел с плавающей точкой
     * Таймер ожидания в секундах. Вызывает внутри Thread.sleep()
     * @param seconds дробное количество секунд ожидания
     */
    public static void waitForSeconds(float seconds) {
        long millisec = (long) (seconds * 10);
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException("Wait() was interrupted by thread " + Thread.currentThread()
                                               + "trace:\n", e);
        }
    }


}
