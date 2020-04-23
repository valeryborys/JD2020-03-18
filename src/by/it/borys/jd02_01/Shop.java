package by.it.borys.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    public static long starttime;
    public static Map<String, Integer> goods;
    public static void main(String[] args) {
        starttime = System.nanoTime();
        goods = new HashMap<>();
        goods.put("brad",2);
        goods.put("milk",2);
        goods.put("meat",8);
        goods.put("fish",5);
        goods.put("oranges",3);
        goods.put("beer",2);
        System.out.println("Shop opened");
        int number = 0;
        List<Buyer> buyers = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
         //   int count = Helper.getRandom(0, 2);
            for (int i = 0; i < Manager.buyersReg(time); i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(1000);
            Manager.graph.put(time,Manager.count);
            }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
        Manager.printToFile();
    }
}
