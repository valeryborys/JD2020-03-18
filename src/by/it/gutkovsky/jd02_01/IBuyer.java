package by.it.gutkovsky.jd02_01;

public interface IBuyer {

    void enterToMarket(); // enter to the shop  (instantly)
    void chooseGoods(); //choose the product (sleep: from 0.5 to 2 sec according to the task)
    void goOut(); // left the shop отправился на выход(instantly)

}
