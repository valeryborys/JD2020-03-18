package by.it.gutkovsky.jd02_02;

import java.util.ArrayDeque;

class QueueBuyers {


    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();
    private static ArrayDeque<Buyer> pensioneerQueue = new ArrayDeque<>();

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

}
