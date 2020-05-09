package by.it.okatov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class CartsQueue {
    private CartsQueue() {

    }

    private static final BlockingDeque<Cart> cartsDeque = new LinkedBlockingDeque<>(50);

    static synchronized Cart getCart(Cart cart) {
        try {
            cartsDeque.putFirst(cart);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Количество свободных корзинок: " + (50 - cartsDeque.size()));
        return cart;
    }

    static void returnCart() {
        cartsDeque.pollLast();
    }
}
