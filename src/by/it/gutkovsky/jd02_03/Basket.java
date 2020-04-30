package by.it.gutkovsky.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Basket {

    private Map<String, Double> basketList = new HashMap<>();

    public Basket(){

    }

//    public Basket(Map<String, Double> basketList) {
//        this.basketList = basketList;
//    }

    public void setBasketList(Map<String, Double> basketList) {
        this.basketList = basketList;
    }

    public Map<String, Double> getBasketList() {
        return basketList;
    }


}
