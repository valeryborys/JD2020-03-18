package by.it.verbitsky.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Basket {

    private List<Good> goodList = new ArrayList<>();

    public Basket() {
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }
}
