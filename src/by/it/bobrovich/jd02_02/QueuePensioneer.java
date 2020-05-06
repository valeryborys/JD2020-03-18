package by.it.bobrovich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueuePensioneer {
    private static Deque<Buyer> queue = new ArrayDeque<>();

    static synchronized void addPensioneer(Buyer buyer){
        queue.addLast(buyer);
    }

    static synchronized Buyer extractPensioneer(){
        return queue.pollFirst();
    }
}
