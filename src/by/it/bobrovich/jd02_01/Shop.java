package by.it.bobrovich.jd02_01;


import java.util.*;

public class Shop {
    static int[] value = new int[60];
    static int[] time = new int[60];


    public static void main(String[] args) {

        int count = 0;
        int number = 0;
        boolean isPensioner = false;
        List<Buyer> buyers = new ArrayList<>();
        System.out.println("Shop opened");

        for (int i = 0; i < 60; i++) {
            int count1 = Helper.count;
            if (i % 4 == 0)
                isPensioner = true;
            time[i] = i;
            value[i] = count1;

            int max = getMax(i, count1);
            int min = getMin(i, count1);

            if (i < 30) {
                if (count1 < min)
                    count = Helper.getRandom(min - count1, min - count1 + 1);
            } else {
                if (count1 < max)
                    count = Helper.getRandom(max - count1, max - count1 + 1);
            }
            for (int j = 0; j < count; j++) {
                Buyer buyer = new Buyer(++number, isPensioner);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(1000);
            isPensioner = false;
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");
        showCount();
    }

    private static int getMax(int time, int count) {
        //int maxCount = 40 + (30 - time);
        return 40 + (30 - time);

    }

    private static int getMin(int time, int count) {
        return time + 10;
    }

    private static void showCount() {
        for (int i = 0; i < time.length; i++) {
            System.out.print("sec = " + time[i] + " v = ||" + value[i] + "||\t");
            if (i % 5 == 0)
                System.out.println();
        }
    }
}
