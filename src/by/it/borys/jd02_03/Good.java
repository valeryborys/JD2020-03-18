package by.it.borys.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Good {
    private static HashMap<String,Integer> goods = new HashMap<>();

   public static void createGoods(){
        goods.put("bread",2);
        goods.put("milk",2);
        goods.put("meat",8);
        goods.put("fish",5);
        goods.put("oranges",3);
        goods.put("beer",2);
    }
    public static HashMap<String,Integer> randomGood(){
        HashMap<String,Integer> randomGood = new HashMap<>();
        int count=0;
        int choose = Helper.getRandom(0, goods.size()-1);
        for (Map.Entry<String, Integer> good : goods.entrySet()) {
            if (count++ == choose) {
                randomGood.put(good.getKey(),good.getValue());
                return randomGood;}
        }return null;
    }

}
