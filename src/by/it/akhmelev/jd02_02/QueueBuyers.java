package by.it.akhmelev.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers  {

    private QueueBuyers() {

    }

    private static Deque<Buyer> queue=new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        queue.addLast(buyer);
    }

    static synchronized Buyer extract(){
        return queue.pollFirst();
    }

}
