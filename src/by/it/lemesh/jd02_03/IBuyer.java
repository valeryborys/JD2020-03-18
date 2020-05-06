package by.it.lemesh.jd02_03;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)

    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

    void toQueue();

    void goOut();
}//отправился на выход(мгновенно)