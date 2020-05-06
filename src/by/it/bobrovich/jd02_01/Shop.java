package by.it.bobrovich.jd02_01;


import java.util.*;

class Shop {
    static int[] valueResult = new int[120];
    static int[] timeResult = new int[120];


    public static void main(String[] args) {

        int count = 0;
        int number = 0;
        boolean isPensioner = false;
        List<Buyer> buyers = new ArrayList<>();
        System.out.println("Shop opened");

        for (int time = 0; time < 120; time++) {
            int count1 = Helper.count;
            if (time % 4 == 0)
                isPensioner = true;
            timeResult[time] = time;
            valueResult[time] = count1;
            count = getCount(time);
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

    private static int getCount(int time) {
        int count1 = Helper.count;
        int max = getMax(time);
        int min = getMin(time);
        int result = 1;
        time = getTime(time);
        if (time < 30) {
            if (count1 < min)
                result = Helper.getRandom(min - count1, min - count1 + 1);
            else{
                return result;
            }
        } else {
            if (count1 < max)
                result = Helper.getRandom(max - count1, max - count1 + 1);
            else{
                return result;
            }
        }
        return result;
    }

    private static int getTime(int time){
        if(time>60)
            return time - 60;
        return time;
    }

    private static int getMax(int time) {
        time = getTime(time);
        return 40 + (30 - time);

    }

    private static int getMin(int time) {
        time = getTime(time);
        return time + 10;
    }

    private static void showCount() {
        for (int i = 0; i < timeResult.length; i++) {
            System.out.print("sec = " + timeResult[i] + " v = ||" + valueResult[i] + "||\t");
            if (i % 5 == 0)
                System.out.println();
        }
    }
}
