package by.it.gutkovsky.jd02_03;


import java.util.HashMap;
import java.util.Map;

class GoodsShelf {

    static final Map<String, Double> LIST_OF_GOODS_ON_SHELF = createGoodsShelf(); // creating list of goods in the shop

    //    fill the shelf with goods
    private static Map<String, Double> createGoodsShelf() {

        Map<String, Double> goodsOnShelf = new HashMap<>(); // String - product name, Integer - price for it
        int goodsQuantiry = Helper.getRandom(100, 200);
        for (int i = 1; i <= goodsQuantiry; i++) {
            goodsOnShelf.put("Product" + i, i * 2.5);
        }
        return goodsOnShelf;
    }


}
