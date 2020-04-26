package by.it.gutkovsky.jd02_02;

import java.util.Map;

public interface IBuyer {

    void enterToMarket(); // enter to the shop  (instantly)
    Map<String, Double> chooseGoods(); //choose the product (sleep: from 0.5 to 2 sec according to the task)
    void goToQueue(); // buyer went to queue
    void goOut(); // left the shop отправился на выход(instantly)

}
