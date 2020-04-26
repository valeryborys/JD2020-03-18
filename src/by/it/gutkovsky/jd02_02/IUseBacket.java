package by.it.gutkovsky.jd02_02;

public interface IUseBacket {

    void takeBacket(); //take a basket (sleep: from 0.5 to 2 sec according to the task )
    void putGoodsToBacket(String goodsName, double price); // put chosen product into the basket (sleep: from 0.5 to 2 sec according to the task)

}
