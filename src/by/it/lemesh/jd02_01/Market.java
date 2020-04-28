package by.it.lemesh.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market is open");
        Helper.fillMarketWithGoods();
        boolean pensioner = false;
        int number = 0;
        List<Buyer> list = new ArrayList<>();
//        long t1 = System.nanoTime();
        for (int time = 0; time < 120; time++) {
            int count = Helper.getCount(time);
            for (int i = 0; i < count; i++) {
                if (number % 4 == 0) pensioner = true;
                Buyer buyer = new Buyer(++number, pensioner);
                buyer.start();
                list.add(buyer);
                pensioner = false;
            }
            Helper.sleep(999);
//            Manager.report(time);
        }
        for (Buyer buyer : list) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market is closed");
 //       Manager.print();
    }
}
