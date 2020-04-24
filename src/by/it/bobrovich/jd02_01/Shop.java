package by.it.bobrovich.jd02_01;


import java.util.*;

public class Shop {

    public static void main(String[] args) {
        int[] sec = new int[60];
        int[] value = new int[60];
        System.out.println("Shop opened");
        int number = 0;
        boolean isPensioneer = false;
        List<Buyer> buyers = new ArrayList<>();
        Deque<Buyer> buyers1 = new LinkedList<>();
        for (int i = 1; i < 10001; i++) {
            if (i % 4 == 0)
                isPensioneer = true;
            buyers1.add(new Buyer(++number, isPensioneer));
            isPensioneer = false;
        }
        System.out.println(buyers1.size());
        for (int time = 0; time < 60; time++) {
            int buyersCount = Buyer.count;
            sec[time] = time;
            value[time] = buyersCount;
            int max, count;
            int min = 0;
            int minBuyersCount = time + 10;
            int maxBuyersCount = 40 + (30-buyersCount);
            if (time < 30) {
                if (buyersCount <= minBuyersCount) {
                    min = minBuyersCount - buyersCount;
                    count = Helper.getRandom(min, min + 2);
                    for (int i = 0; i < count; i++) {
                        buyers.add(buyers1.peekFirst());
                        buyers1.pollFirst().start();
                    }
                }
            } else {
                if (buyersCount > maxBuyersCount){
                    Helper.sleep(1000);
                    continue;
                }else{
                    max = maxBuyersCount - buyersCount;
                    count = Helper.getRandom(max-2, max);
                    for (int i = 0; i < count; i++) {
                        buyers.add(buyers1.peekFirst());
                        buyers1.pollFirst().start();
                    }
                }
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
        System.out.println("Shop closed");
        System.out.println(buyers1.size());
        for (int i = 0; i < sec.length; i++) {
            System.out.printf("%d %d    ", sec[i], value[i]);
            if(i%10 == 0)
                System.out.println();
        }
    }

    private static int getMax(int time, int count) {
        int maxCount = 40 + (30 - time);
        return maxCount - count;

    }

    private static int getMin(int time, int count) {
        int min = time + 10 - count;
        if (min < 0)
            return 0;
        else
            return min;
    }
}
