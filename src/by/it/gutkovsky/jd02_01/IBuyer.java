package by.it.gutkovsky.jd02_01;

public interface IBuyer {

    void voidenterToMarket(); //вошел в магазин (мгновенно)
    void voidchooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void voidgoOut(); //отправился на выход(мгновенно)

}
