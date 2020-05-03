package by.it.okatov.jd02_03.Test;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final Map<String, Integer> goodsInCart = new HashMap<>();


    void clearCart() {
        this.goodsInCart.clear();
    }
}
