package by.it.bobrovich.jd02_01;

import java.util.HashMap;

public class Manager {

    static HashMap<String, Integer> goods = new HashMap<>();
    static{
        Goods milk = new Goods("Молоко", 100);
        Goods rice = new Goods("Рис", 150);
        Goods water = new Goods("Вода", 50);
        Goods coffee = new Goods("Кофе", 200);
        goods.put(milk.getName(), milk.getPrice());
        goods.put(water.getName(), water.getPrice());
        goods.put(rice.getName(), rice.getPrice());
        goods.put(coffee.getName(), coffee.getPrice());
        }


    static final int K_SPEED = 1000;
}
