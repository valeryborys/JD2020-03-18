package by.it.akhmelev.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers  {

    private QueueBuyers() {

    }

    private static final BlockingDeque<Buyer> queue=new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer){
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract(){
        return queue.pollFirst();
    }

}
