package by.it.tolstik.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Магазин открылся");
        int number = 1;
        List<Buyer> buyers = new ArrayList<>();
        for (int time = 0; time < 5; time++) {
            int count = Helper.getRandom(0,2);
            for (int i = 0; i <= count ; i++) {
                Buyer buyer = new Buyer(number++);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(1000,100);
        }
        for (Buyer buyer : buyers) {
            buyer.join();
        }
        System.out.println("Магазин закрылся. Кол-во посетителей: " + number);
    }
}


