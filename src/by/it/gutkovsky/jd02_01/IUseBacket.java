package by.it.gutkovsky.jd02_01;

public interface IUseBacket {

    void takeBacket(); //take a basket (sleep: from 0.5 to 2 sec according to the task )
    void putGoodsToBacket(String goodsName, int price); // put chosen product into the basket (sleep: from 0.5 to 2 sec according to the task)

}
