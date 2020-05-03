package by.it.okatov.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Cart implements ICart, Runnable {
    private final Map<String, Integer> cart;
    private final String name;
    private int number;

    int getNumber() {
        return this.number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    Cart(int number, Buyer owner) {
        setNumber(number);
        setOwner(owner.toString());
        name = String.format("%s #%d", "Cart", getNumber());
        cart = new HashMap<>();
    }


    @Override
    public void fillCart(Map.Entry entry) {
        cart.put((String) entry.getKey(), (Integer) entry.getValue());
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

    @Override
    public String toString() {
        return String.format("Корзинка №" + getNumber());
    }

    @Override
    public void run() {
        System.out.println("Корзинка: " + this + " взята покупателем: " + getOwner());
        try {
            Utils.CARTS_SEMAPHORE.acquire();
            //wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //Buyer.CARTS_SEMAPHORE.release();
        }
    }
}
