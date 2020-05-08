package by.it.bobrovich.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Backet {
    private List<String> listGoods = new ArrayList<>();

    public Backet() {
    }

    public void addGoods(String goods) {
        listGoods.add(goods);
    }

    public List<String> getListGoods() {
        return listGoods;
    }
}
