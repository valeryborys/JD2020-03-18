package by.it.tolstik.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args) {
        System.out.println("Магазин открылся");
        int number = 1;
        List<Buyer> buyers = new ArrayList<>();
        for (int time = 0; time < 120;) {
            if (time <= 30) {
                Buyer buyer = new Buyer(number++);
                buyer.start();
                buyers.add(buyer);
                Helper.sleep(3000,100);
                time += 3;
            } else if (time <=60) {
                Buyer buyer = new Buyer(number++);
                buyer.start();
                buyers.add(buyer);
                Helper.sleep(1000,100);
                time++;
            } else if (time <=90) {
                Buyer buyer = new Buyer(number++);
                buyer.start();
                buyers.add(buyer);
                Helper.sleep(3000,100);
                time += 3;
            } else {
                Buyer buyer = new Buyer(number++);
                buyer.start();
                buyers.add(buyer);
                Helper.sleep(1000,100);
                time++;
            }
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Магазин закрылся. Кол-во посетителей: " + number);
    }
}


