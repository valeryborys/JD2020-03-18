package by.it.borys.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer,IUseBasket{

    private boolean pensioneer = false;


    public Buyer(int number) {
        super("Buyer № " + number + " ");
        if (Helper.getRandom(0, 100)<25) pensioneer=true;
        Manager.buyersCount(true);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
       putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        if (pensioneer) timeout *= 1.5;
        Helper.sleep(timeout);

    }

    @Override
    public void goOut() {
        System.out.println(this + "leaved the shop");
        Manager.buyersCount(false);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "takes the basket");
//        int timeout = Helper.getRandom(500, 2000);
//        if (pensioneer) timeout *= 1.5;
//        Helper.sleep(timeout);
       }

    @Override
    public void putGoodsToBasket() {
        for (int i = 0; i <Helper.getRandom(1,4) ; i++) {
            System.out.println(this + "put the "+ randomGood()+ " to the basket");
            int timeout = Helper.getRandom(500, 2000);
            if (pensioneer) timeout *= 1.5;
            Helper.sleep(timeout);
        }
        System.out.println(this + "finished to choose goods");
    }
    private String randomGood(){
        int count=0;
        int choose = Helper.getRandom(0,Shop.goods.size());
        for (Map.Entry<String, Integer> good : Shop.goods.entrySet()) {
            if (count++ == choose) return good.getKey()+" for $ "+good.getValue();
        }return null;
    }
}
