package by.it.borys.jd02_02;

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
        goods.put("bread",2);
        goods.put("milk",2);
        goods.put("meat",8);
        goods.put("fish",5);
        goods.put("oranges",3);
        goods.put("beer",2);
        System.out.println("Shop opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
             Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        while (Manager.shopOpen()){
       // for (int time = 0; time < 120; time++) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; Manager.shopOpen() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000);
            //Manager.graph.put(time, Manager.count);
            }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
        //Manager.printToFile();
    }
}
