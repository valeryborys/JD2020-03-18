package by.it.szamostyanin.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {
    private static final BlockingDeque<Buyer>queue=new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            queue.putLast(buyer);   //метод putLast завесит покупателя, если он пытается добавиться 31
        } catch (InterruptedException e) {  //если будет больше capacity (31), то заблокируется наш поток, поэтом нужен try catch
            e.printStackTrace();
        }
    }

    static Buyer extract() {
        return queue.pollFirst();
    }
}