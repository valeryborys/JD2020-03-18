package by.it.tolstik.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {

    boolean pensioner;


    public Buyer(int number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket(); //вошел в магазин
        chooseGoods(); //взял корзину, начал выбирать товары, положил товары в корзину, завершил выбирать товары
        goOut(); //вышел из магазина

    }

    @Override
    public void enterToMarket() {
        if (isPensioner()) System.out.println(this + "вошел в магазин, он пенсионер");
        else System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        takeBacket(); //взял корзину
        System.out.println(this + "начал выбирать товары"); //начал выбирать товары
        int timeout;
        if (pensioner) timeout = (int) (Helper.getRandom(500, 2000)*Finals.K_FOR_OLDER_PEOPLE);
        else timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        putGoodsToBacket(); //положил товары в корзину
        if (pensioner) System.out.println(this + "завершил выбирать товары, он пенсионер");
        else System.out.println(this + "завершил выбирать товары"); //завершил выбирать товары
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public boolean isPensioner() {
        int flag = Helper.getRandom(1,4);
        if (flag == 1) pensioner = true;
        return pensioner;
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Map<String, Integer> goods = new HashMap<>();
        int timeout;
        if (pensioner) timeout = (int) (Helper.getRandom(500, 2000)*Finals.K_FOR_OLDER_PEOPLE);
        else timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        int count = Helper.getRandom(1, 4);
        int iteration = 0;
        for (Map.Entry<String, Integer> entry : Goods.goodsList().entrySet()) {
            if (iteration < count) {
                System.out.println(this + "положил в корзину " + entry.getKey() + " за " + entry.getValue() + " рублей.");
                iteration++;
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
