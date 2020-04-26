package by.it.szamostyanin.jd02_02;

import java.util.ArrayDeque;

public class QueueBuyers extends ArrayDeque {
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        queue.addLast(buyer);
    }

    static synchronized Buyer extract (){
        return queue.pollFirst();
    }

}
