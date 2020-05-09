package by.it.novikov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private static final BlockingDeque<Buyer>QUEUE= new LinkedBlockingDeque<>(30);


    static void add(Buyer buyer){

        try{
            QUEUE.putLast(buyer);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    static Buyer extract(){return  QUEUE.pollFirst();}
}