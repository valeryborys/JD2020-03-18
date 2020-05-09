package by.it.lemesh.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Baskets {
    private static BlockingDeque<String> baskets = new LinkedBlockingDeque<>(50);

    public static void createBaskets() {
        for (int i = 1; i <= 50; i++) {
            baskets.addLast("basket #" + i);
        }
    }

    public static String takeBasket() {
        String basket = null;
        try {
            basket = baskets.takeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return basket;
    }

    public static void putBasket(String basket) {
        baskets.addLast(basket);
    }
}
