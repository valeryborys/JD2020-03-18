package by.it.bobrovich.jd02_01;

import java.util.HashMap;

public class Goods {
    private String name;
    private int price;


    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public java.lang.String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public java.lang.String toString() {
        return "Good{" +
                "name='" + name +
                ", price=" + price +
                '}';
    }


}
