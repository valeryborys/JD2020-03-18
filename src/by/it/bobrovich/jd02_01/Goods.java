package by.it.bobrovich.jd02_01;

public class Goods {
    //оставить и создать отдельно hashmap статический с товарами либо создать прямо здесь
    private String name;
    private int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name +
                ", price=" + price +
                '}';
    }
}
