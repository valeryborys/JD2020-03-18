package by.it.okatov.jd02_03;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


class BuyersQueue {
    private BuyersQueue() {

    }

    private static final BlockingQueue<Buyer> priorityQueue
            = new PriorityBlockingQueue<>(30, (buyer1, buyer2) -> {
        if (buyer1.isElder() && buyer2.isElder()) {
            return Integer.compare(buyer1.getNumber(), buyer2.getNumber());
        } else if (buyer1.isElder() && !buyer2.isElder()) {
            return -1;
        } else if (!buyer1.isElder() && buyer2.isElder()) {
            return 1;
        } else {
            return Integer.compare(buyer1.getNumber(), buyer2.getNumber());
        }
    });

    static void add(Buyer buyer) {
        try {
            priorityQueue.put(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer extract() {
        return priorityQueue.poll();
    }


}























