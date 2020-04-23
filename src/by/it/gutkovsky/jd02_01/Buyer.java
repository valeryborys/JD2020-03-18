package by.it.gutkovsky.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private int goodsQuantityInTheBasket = 4; // goods quantity in buyers shopping list
    private boolean pensioner;
    private static final double PENSIONER_FACTOR = 1.5;

    public Buyer(int number) {
        super("Buyer № " + number + " ");
        this.pensioner = false;
    }

    public Buyer(int number, boolean pensioner) {
        super("Buyer № " + number + "(The Buyer is pensioner)" + " ");
        this.pensioner = pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods(); // in this method buyer choose goods and put them into the basket
        goOut();
    }

    private void sleepMethod(int start, int stop, boolean pensione) {
        int timeout;
        if (pensioner) {
            timeout = (int) (Helper.getRandom(start, stop) * PENSIONER_FACTOR);
        } else {
            timeout = Helper.getRandom(start, start);
        }
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to shop");

    }

    @Override
    public void takeBacket() {
        sleepMethod(500, 2000, pensioner);
        System.out.println(this + "take a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        for (int i = 0; i < goodsQuantityInTheBasket; i++) {
            sleepMethod(500,2000, pensioner);

            //choose goods from goods shelf
            String goodsName = "Product" + Helper.getRandom(1, GoodsShelf.LIST_OF_GOODS_ON_SHELF.size()); // key for Map goodsOnShelf - chosenGoods
            int price = GoodsShelf.LIST_OF_GOODS_ON_SHELF.get(goodsName); // value for Map chosenGoods

            putGoodsToBacket(goodsName, price); // call the method which puts goods into the basket
        }
        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void putGoodsToBacket(String goodsName, int price) {
        sleepMethod(500, 2000, pensioner);
        System.out.println(this + "put " + goodsName + " to the basket, price for it is " + price);
    }

    @Override
    public void goOut() {
        System.out.println(this + "get out from the shop");
    }

    @Override
    public String toString() {
        return getName();
    }


}
