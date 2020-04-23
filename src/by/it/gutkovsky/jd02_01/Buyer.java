package by.it.gutkovsky.jd02_01;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {
    public Buyer(int number) {
        super("Buyer № " + number + " ");
    }

    private int goodsQuantityInTheBasket = 4; // quantity goods in buyers shopping list

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods(); // in this method buyer choose goods and put them into the basket
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to shop");

    }

    @Override
    public void takeBacket() {
        int timeout = Helper.getRandom(500, 2000);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
        System.out.println(this + "take a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        for (int i = 0; i < goodsQuantityInTheBasket; i++) {
            int timeout = Helper.getRandom(500, 2000);
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
            }

            //choose goods from goods shelf
            String goodsName = "Product" + Helper.getRandom(1, GoodsShelf.LIST_OF_GOODS_ON_SHELF.size()); // key for Map goodsOnShelf - chosenGoods
            int price = GoodsShelf.LIST_OF_GOODS_ON_SHELF.get(goodsName); // value for Map chosenGoods

            putGoodsToBacket(goodsName, price); // call the method which puts goods into the basket
        }

        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void putGoodsToBacket(String goodsName, int price) {
        int timeout = Helper.getRandom(500, 2000);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted " + Thread.currentThread(), e);
        }
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
