package by.it.okatov.jd02_02;

public interface IBuyer {

    void enterToMarket(); //вошел в магазин (мгновенно)

    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

    void putGoodsToCart();

    void goToQueue();

    void goOut(); //отправился на выход(мгновенно)

}