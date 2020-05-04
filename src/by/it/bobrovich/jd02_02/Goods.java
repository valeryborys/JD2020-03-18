package by.it.bobrovich.jd02_02;

public class Goods {
    private String name;
    private int price;


    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
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
