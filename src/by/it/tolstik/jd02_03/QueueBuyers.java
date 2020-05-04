package by.it.tolstik.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    static final Object MONITOR = new Object();

    private static int cashiersNeeded = 0;

    static final BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        setCashiers();
    }

    static Buyer extract() {
        for (Buyer buyer : deque) {
            if (buyer.isPensioner()) {
                return deque.remove();
            }
        }
        return deque.pollFirst();
    }



    public static int getCashNeed() {
        return cashiersNeeded;
    }

    private static void setCashiers() {
        if (deque.size() == 0) cashiersNeeded = 0;
        else if (deque.size() <= 5) cashiersNeeded = 1;
        else if (deque.size() <= 10) cashiersNeeded = 2;
        else if (deque.size() <= 15) cashiersNeeded = 3;
        else if (deque.size() <= 20) cashiersNeeded = 4;
        else cashiersNeeded = 5;
    }
}
