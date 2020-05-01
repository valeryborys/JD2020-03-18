package by.it.lemesh.jd02_02;

import java.util.*;

public class QueueBuyers {
    static Deque<Buyer> deque = new ArrayDeque<>();
    static Comparator<Buyer> pComparator = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer b1, Buyer b2) {
            return Boolean.compare(b1.pensioner, b2.pensioner);
        }
    };
    static Queue<Buyer> queue = new PriorityQueue<>(pComparator);

    static synchronized void add(Buyer buyer) {
        deque.addLast(buyer);
//        queue.add(buyer);
    }

    static synchronized Buyer extract() {
        Buyer pens = null;
        for (Buyer b : deque) {
            if (b.pensioner) {
                pens = b;
                break;
            }
        }
        if (pens == null) return deque.pollFirst();
        else {
            deque.remove(pens);
            return pens;
        }
    }
/*
    static synchronized Buyer extract() {
        return queue.poll();
    }*/

    static synchronized int getLength() {
        return deque.size();
     //   return queue.size();
    }
}
