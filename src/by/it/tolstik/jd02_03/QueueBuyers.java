package by.it.tolstik.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class QueueBuyers {

    private static final AtomicInteger cashiersNeeded = new AtomicInteger(0);

    private static final BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);

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

    static int getQueueValue() {
        return deque.size();
    }

    static int getCashNeed() {
        return cashiersNeeded.get();
    }

    private static void setCashiers() {
        if (deque.size() == 0) cashiersNeeded.set(0);
        else if (deque.size() <= 5) cashiersNeeded.set(1);
        else if (deque.size() <= 10) cashiersNeeded.set(2);
        else if (deque.size() <= 15) cashiersNeeded.set(3);
        else if (deque.size() <= 20) cashiersNeeded.set(4);
        else cashiersNeeded.set(5);
    }
}
