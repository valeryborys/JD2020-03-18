package by.it.gutkovsky.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


class QueueBuyers {

    private static final BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract() {
        for (Buyer buyer : queue) {
            if (buyer.isPensioner()) {
                return queue.remove();
            }
        }
        return queue.pollFirst();
    }

    static int queueSize() {
        return queue.size();
    }

}
