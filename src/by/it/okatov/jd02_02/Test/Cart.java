package by.it.okatov.jd02_02.Test;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> goodsInCart = new HashMap<>();

    public Map<String, Integer> getGoodsInCart() {
        return goodsInCart;
    }

    public void setGoodsInCart(Map<String, Integer> goodsInCart) {
        this.goodsInCart = goodsInCart;
    }

    Cart() {

    }

    Cart(Map<String, Integer> goodsInCart) {
        this.goodsInCart = goodsInCart;
    }

    Cart(Map.Entry<String, Integer> entry) {
        this.goodsInCart.put(entry.getKey(), entry.getValue());
    }

    Map<String, Integer> addGoodsToCart(Map.Entry<String, Integer> entry) {
        this.goodsInCart.put(entry.getKey(), entry.getValue());
        return goodsInCart;
    }

    void clearCart() {
        this.goodsInCart.clear();
    }
}
