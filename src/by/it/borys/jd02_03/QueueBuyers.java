package by.it.borys.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueBuyers {
    private final static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);
    private static AtomicInteger cashiersNeeded = new AtomicInteger(0);
    static void add(Buyer buyer){
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setCashiers();
    }
    static Buyer extract(){
        Buyer buyer = queue.pollFirst();
        setCashiers();
        return buyer;
    }

    private static void setCashiers(){
       if (queue.size()== 0) cashiersNeeded.set(0);
       else if (queue.size()<=5 ) cashiersNeeded.set(1);
       else if ( queue.size()<=10 ) cashiersNeeded.set(2);
       else if (queue.size()<=15 ) cashiersNeeded.set(3);
       else if (queue.size()<=20 ) cashiersNeeded.set(4);
       else cashiersNeeded.set(5);

    //  System.out.println(getQueueSize()+" "+cashiersNeeded.get());//посмотреть количество людей в очереди и требуемых кассиров
    }

    public static int getCashNeed(){
        return cashiersNeeded.get();
    }
    public static int getQueueSize(){
        return queue.size();
    }
}
