package by.it.tolstik.jd02_01;

class Buyer extends Thread implements IBuyer,IUseBacket {

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
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        takeBacket(); //взял корзину
        System.out.println(this + "начал выбирать товары"); //начал выбирать товары
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        putGoodsToBacket(); //положил товары в корзину
        System.out.println(this + "завершил выбирать товары"); //завершил выбирать товары
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBacket() {

    }

    @Override
    public String toString() {
        return getName();
    }
}
