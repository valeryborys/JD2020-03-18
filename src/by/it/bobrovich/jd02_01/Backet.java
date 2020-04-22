package by.it.bobrovich.jd02_01;


import java.util.ArrayList;
import java.util.List;

public class Backet {
    //hashmap либо оставить и формируется список из названий а цена берется из goods
    private List<Goods> listGoods = new ArrayList<>();

    public Backet(List<Goods> listGoods) {
        this.listGoods = listGoods;
    }
    //hashmap
    public void addGoods(Goods goods) {
        listGoods.add(goods);
    }

    public List<Goods> getListGoods() {
        return listGoods;
    }
}
