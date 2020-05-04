package by.it.bobrovich.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Backet {
    //hashmap либо оставить и формируется список из названий а цена берется из goods
    private List<String> listGoods = new ArrayList<>();

    public Backet() {
    }
    //hashmap
    public void addGoods(String goods) {
        listGoods.add(goods);
    }

    public List<String> getListGoods() {
        return listGoods;
    }
}
