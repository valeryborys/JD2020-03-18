package by.it.gutkovsky.jd02_02;

import java.util.Map;

public interface IUseBacket {

    void takeBacket(); //take a basket (sleep: from 0.5 to 2 sec according to the task )
    void putGoodsToBacket(String goodsName, double price); // put chosen product into the basket (sleep: from 0.5 to 2 sec according to the task)
    Map<String, Double> provideChosenGoodsToCashier (Map<String, Double> shoppingList); // give goods to cashier for calculation and payment

}
