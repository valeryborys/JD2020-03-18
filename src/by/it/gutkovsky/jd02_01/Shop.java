package by.it.gutkovsky.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args) {

        GoodsShelf goodsShelf = new GoodsShelf(); // creating list of goods in the shop
        int comeIn = 0; // quantity of buyers who came into the shop
        int comeOut = 0; // quantity of buyers who left the shop
        int timeForCalc = 0; // time period for calculation

        System.out.println("shop is opened");
        int number = 0;
        List<Buyer> buyers = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; i < count; i++) {
                Buyer buyer;
                if ((buyers.size() %4 != 0)) {
                buyer = new Buyer(++number);
                } else {                                    // pensioner is coming!!!
                    buyer = new Buyer(++number, true);
                }
                buyer.start();
                buyers.add(buyer);

            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop is closed");


    }
}
