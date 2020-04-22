package by.it.bobrovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket{
    //переписать логику в соответствии с backet и goods
    public Buyer(int number) {
        super("Buyer №" + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        Backet backet = takeBacket();
        chooseGoods();

        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the shop");
    }

    @Override
    public Backet takeBacket() {
        List<Goods> listGoods = new ArrayList<>();
        return new Backet(listGoods);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "start to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        System.out.println(this + "finished to choose goods");
        Helper.sleep(timeout);
    }

    @Override
    public void putGoodsToBacket(Backet backet, Goods goods) {
        backet.addGoods(goods);
    }

    @Override
    public void goOut() {
        System.out.println(this + "leave the shop");
    }

    @Override
    public String toString() {
        return getName();
    }
}
