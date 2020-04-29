package by.it.verbitsky.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Backet {

    private List<Good> goodList = new ArrayList<>();

    public Backet() {
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }
}
