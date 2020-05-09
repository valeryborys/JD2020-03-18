package by.it.verbitsky.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class ShopQueue {
    private static Deque<Buyer> shopQueue = new ArrayDeque<>();
    //отдельная очередь для пенсионеров,
    private static Deque<Buyer> shopPensionerQueue = new ArrayDeque<>();

    //методы синхронизируются на самом классе, т.к. они статичен
    static void lineUp(Buyer buyer) {
        if (buyer.isPensioner()) {
            shopPensionerQueue.addLast(buyer);
            return;
        }
        shopQueue.addLast(buyer);
    }

    static synchronized Buyer extract() {
        if (shopPensionerQueue.size() > 0) {
            return shopPensionerQueue.pollFirst();
        }
        return shopQueue.pollFirst();
    }

    static synchronized int getQueueCount() {
        return shopQueue.size() + shopPensionerQueue.size();
    }


}
