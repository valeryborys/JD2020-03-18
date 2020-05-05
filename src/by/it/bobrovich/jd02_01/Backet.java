package by.it.bobrovich.jd02_01;


import java.util.ArrayList;
import java.util.List;

class Backet {
    private List<String> listGoods = new ArrayList<>();

    Backet() {
    }

    void addGoods(String goods) {
        listGoods.add(goods);
    }

    List<String> getListGoods() {
        return listGoods;
    }
}
