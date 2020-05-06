package by.it.bobrovich.jd02_01;

import java.util.HashMap;

class Goods {
    private String name;
    private int price;


    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name +
                ", price=" + price +
                '}';
    }


}
