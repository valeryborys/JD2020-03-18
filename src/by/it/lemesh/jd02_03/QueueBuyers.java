package by.it.lemesh.jd02_03;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {
    private static BlockingDeque<Buyer> lbDeque = new LinkedBlockingDeque<>(30);
    static Comparator<Buyer> pComparator = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer b1, Buyer b2) {
            return -Boolean.compare(b1.pensioner, b2.pensioner);
        }
    };
    static Queue<Buyer> queue = new PriorityQueue<>(pComparator);

    static void add(Buyer buyer) {
        try {
            lbDeque.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract() {
        Buyer pens = null;
        for (Buyer b : lbDeque) {
            if (b.pensioner) {
                pens = b;
                break;
            }
        }
        if (pens == null) return lbDeque.pollFirst();
        else {
            lbDeque.remove(pens);
            return pens;
        }
    }

    static int getLength() {
        return lbDeque.size();
    }
}
