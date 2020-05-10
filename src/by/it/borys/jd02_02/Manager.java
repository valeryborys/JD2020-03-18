package by.it.borys.jd02_02;

import by.it.borys.jd01_14.TaskA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;


public class Manager {
    static final int K_SPEED = 100;
    static Deque<Integer> cashierQueue = new ArrayDeque<Integer>() {
        {
            this.addLast(1);
            this.addLast(2);
            this.addLast(3);
            this.addLast(4);
            this.addLast(5);
        }
    };
    final static Object MONITOR = new Object();
    private static final int PLAN = 100;
    private volatile static int inCount = 0;
    private volatile static int outCount = 0;
    public volatile static int inStoreRigthNow = 0;

    static boolean shopOpen() {
        return inCount < PLAN;
    }

    static boolean planComplete() {
        return outCount == PLAN;
    }

    static void buyerAddToShop() {
        synchronized (MONITOR) {
            inCount++;
            inStoreRigthNow++;
        }
    }

    static void buyerLeaveTheShop() {
        synchronized (MONITOR) {
            outCount++;
            inStoreRigthNow--;
        }
    }

    static synchronized void openCashier() {
        Integer number = cashierQueue.pollFirst();
        if (number != null) {
        Cashier cashier = new Cashier(number);
        Thread thread = new Thread(cashier);
        Shop.threads.add(thread);
        thread.start();
        }
    }


    static synchronized int buyersReg(int second, int inStore) {
        int sec = second%60;
        int res = 0;
        if (sec <= 30) {
            res = 10 + sec - inStore;
            if (res < 0) res = 0;
        }
        return res;
    }

    public volatile static TreeMap<Integer, Integer> graph = new TreeMap<>();


    public static void printToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(TaskA.dir(Manager.class) + "log.txt"))) {
            for (Map.Entry<Integer, Integer> el : graph.entrySet()) {
                pw.println(el.getKey() + " " + el.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
