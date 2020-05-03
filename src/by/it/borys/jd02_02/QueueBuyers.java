package by.it.borys.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    public final static Object MONITOR = new Object();
    private static Deque<Buyer> queue = new ArrayDeque<>();
    private volatile static int cashiersNeeded = 0;
    static synchronized void add(Buyer buyer){
        queue.addLast(buyer);
        setCashiers();
    }
    static synchronized Buyer extract(){
        Buyer buyer = queue.pollFirst();
        setCashiers();
        return buyer;
    }

    private synchronized static void setCashiers(){
       if (queue.size()== 0) cashiersNeeded = 0;
       else if (queue.size()<=5 ) cashiersNeeded = 1;
       else if ( queue.size()<=10 ) cashiersNeeded = 2;
       else if (queue.size()<=15 ) cashiersNeeded = 3;
       else if (queue.size()<=20 ) cashiersNeeded = 4;
       else cashiersNeeded = 5;
        //System.out.println(queue.size()+" "+cashiersNeeded);//посмотреть количество людей в очереди и требуемых кассиров
    }

    public synchronized static int getCashNeed(){
        return cashiersNeeded;
    }
    public synchronized static int getQueueSize(){
        return queue.size();
    }
}
