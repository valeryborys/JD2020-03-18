package by.it.tolstik.jd02_01;

import java.util.HashMap;

class Goods {

    static HashMap<String, Integer> goodsList() {
        //TODO доработать рандомный вывод
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
        goods.put("вилки", 150);
        return goods;
    }

}
