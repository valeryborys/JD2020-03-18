package by.it.tolstik.jd02_01;

import java.util.*;

class Goods {
    static ArrayList<String> getGoodsName() {
        return new ArrayList<>(goodsList().keySet());
    }
    static ArrayList<Integer> getGoodsPrice() {
        return new ArrayList<>(goodsList().values());
    }

    static HashMap<String, Integer> goodsList() {
        HashMap<String, Integer> goods = new HashMap<>();
        goods.put("молоко", 100);
        goods.put("хлеб", 90);
        goods.put("колбаса", 400);
        goods.put("грибы", 650);
        goods.put("огурцы", 120);
        goods.put("помидоры", 190);
        goods.put("бананы", 150);
        goods.put("пиво", 70);
        goods.put("водка", 450);
        goods.put("подгузники", 3700);
        goods.put("рюмки", 510);
        goods.put("сыр", 260);
        goods.put("креветки", 960);
        goods.put("рыба", 750);
        goods.put("салат", 150);
        goods.put("полотенце", 210);
        goods.put("мыло", 40);
        goods.put("веревка", 30);
        goods.put("порошок", 180);
        goods.put("тушенка", 195);
        goods.put("вилки", 150);
        return goods;
    }



}
