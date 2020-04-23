package by.it.tolstik.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {

    public static Map<String,Integer> goodsList() {
        Map<String,Integer> goods = new HashMap<>();
        goods.put("Молоко",100);
        goods.put("Хлеб",90);
        goods.put("Колбаса",400);
        goods.put("Вино",650);
        return goods;
    }
}
