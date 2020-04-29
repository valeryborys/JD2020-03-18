package by.it.verbitsky.jd02_01;

class Good {
    private String name;

    private double price;

    public Good(String name) {
        this.name = name;
        this.price = 0;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
