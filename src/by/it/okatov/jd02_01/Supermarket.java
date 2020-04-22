package by.it.okatov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    public static void main(String[] args) {
        System.out.println("Grand opening!");
        Utils.sethMap();
        int number = 0;
        int numberOfElders = 0;
        List<Buyer> buyers = new ArrayList<>();
        Buyer buyer;
        long lt = System.nanoTime();
        int firstRange = 0;
        int secondRange = 0;
        int thirdRange = 0;

        while (((System.nanoTime() - lt) / 1e9) < 30.0f) {
            int count = Utils.getRandom(0, (int) ((System.nanoTime() - lt) / 1e9));
            for (int i = 0; i <= count; i++) {
                if (count % 4 == 0) {
                    buyer = new Buyer(++number, true);
                    numberOfElders++;
                } else {
                    buyer = new Buyer(++number);
                }

                buyer.start();
                buyers.add(buyer);
            }
        }

        for (int time = 0; time < 120; time++) {
            int count = Utils.getRandom(0, 2);
            for (int i = 0; i <= count; i++) {
                if (time % 4 == 0) {
                    buyer = new Buyer(++number, true);
                    numberOfElders++;
                } else {
                    buyer = new Buyer(++number);
                }

                buyer.start();
                buyers.add(buyer);
            }

        }

        for (Buyer customer : buyers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long dt = System.nanoTime() - lt;
        System.out.println("Grand closing!");
        System.out.println("Количество обычных покупателей: " + (buyers.size() - numberOfElders));
        System.out.println("Количество пенсионеров: " + numberOfElders);
        System.out.println("Время исполнения: " + dt / 1e9 + "секунд");
    }
}
