package by.it.okatov.jd02_03;

interface IBuyer {

    void enterToMarket(); //вошел в магазин (мгновенно)

    void getCart();

    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

    void putGoodsToCart();

    void goToQueue();

    void returnCart();

    void goOut(); //отправился на выход(мгновенно)

}