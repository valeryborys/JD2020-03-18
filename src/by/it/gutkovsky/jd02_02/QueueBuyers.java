package by.it.gutkovsky.jd02_02;

import java.util.ArrayDeque;

class QueueBuyers {

    static final Object MONITOR_BUYERS = new Object();

    private static final ArrayDeque<Buyer> queue = new ArrayDeque<>();
    private static final ArrayDeque<Buyer> pensioneerQueue = new ArrayDeque<>();

    static synchronized void  add(Buyer buyer){
        if (buyer.isPensioner()) {
            pensioneerQueue.addLast(buyer);
        } else {
            queue.addLast(buyer);
        }
    }

    static synchronized Buyer extract(){
        if(pensioneerQueue.size() > 0) {
            return pensioneerQueue.pollFirst();
        }
        else return queue.pollFirst();
    }

    static synchronized int queueSize(){
//        synchronized (MONITOR_BUYERS) {
            return queue.size() + pensioneerQueue.size();
//        }
    }

}
