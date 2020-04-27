package by.it.gutkovsky.jd02_02;


import java.util.HashMap;
import java.util.Map;

class GoodsShelf {

    static final Map<String, Integer> LIST_OF_GOODS_ON_SHELF = createGoodsShelf(); // creating list of goods in the shop

    //    fill the shelf with goods
    private static Map<String, Integer> createGoodsShelf() {

        Map<String, Integer> goodsOnShelf = new HashMap<>(); // String - product name, Integer - price for it
        int goodsQuantiry = Helper.getRandom(100, 200);
        for (int i = 1; i <= goodsQuantiry; i++) {
            goodsOnShelf.put("Product" + i, i * 3);
        }
        return goodsOnShelf;
    }


}
