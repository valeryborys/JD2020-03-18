package by.it.okatov.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Buyer(int num) {
        super(String.format("Buyer #%d ", num));
    }

    public Buyer(int num, boolean isElder) {
        super(String.format("Buyer (pensioneer) #%d ", num));
    }


    @Override
    public void run() {
        enterToMarket();
        takeCart();
        chooseGoods();
        putGoodsToCart();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enters the supermarket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "starts to collect goods");
        int timeout = Utils.getRandom(1, 3);
        Utils.waitForSeconds(timeout);
        System.out.println(this + "finishes collecting goods");

    }

    @Override
    public void goOut() {
        System.out.println(this + "returns a cart in the supermarket");
        Utils.waitForSeconds(1);
        System.out.println(this + "leaves the supermarket");

    }

    @Override
    public void takeCart() {
        int timeout = Utils.getRandom(0, 2);
        Utils.waitForSeconds(timeout);
        System.out.println(this + "takes a cart in the supermarket");
    }

    @Override
    public void putGoodsToCart() {
        int goodsQuant = Utils.getRandom(0, 4);
        int i = 0;
        int timeout = Utils.getRandom(0, 2);

        for (Map.Entry<String, Integer> entry : Utils.gethMap().entrySet()) {
            Utils.waitForSeconds(timeout);
            if (i >= goodsQuant) {
                break;
            }
            String key = entry.getKey();
            int val = entry.getValue();
            System.out.println(this + "puts " + key + " for $" + val);
            i++;
        }
    }


    @Override
    public String toString() {
        return getName();
    }
}
