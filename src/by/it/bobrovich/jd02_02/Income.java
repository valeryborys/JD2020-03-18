package by.it.bobrovich.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Income {
    Map<String, Integer> goodsCount = new HashMap<>();
    //int sum = 0;

    public Income(){
        List<String> listGoods = new ArrayList<>(Manager.goods.keySet());
        for (String listGood : listGoods) {
            goodsCount.put(listGood, 0);
        }
    }

    public void addGoods(String goods){
        int count = goodsCount.get(goods)+1;
        goodsCount.put(goods,count);
    }

    public Map<String, Integer> getGoodsCount() {
        return goodsCount;
    }
}
