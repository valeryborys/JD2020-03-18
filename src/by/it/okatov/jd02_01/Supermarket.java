package by.it.okatov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    public static void main(String[] args) {
        System.out.println("Grand opening!");
        Utils.sethMap();
        int number = 0;
        List<Buyer> buyers = new ArrayList<>();

        long lt = System.nanoTime();
        for (int time = 0; time < 120; time++) {
            int count = Utils.getRandom(0, 2);
            for (int i = 0; i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
            }

        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long dt = System.nanoTime() - lt;
        System.out.println("Grand closing!");
        System.out.println("Время исполнения: " + dt / 1e9 + "секунд");
    }
}
